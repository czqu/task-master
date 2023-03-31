package net.czqu.taskmaster.security.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import net.czqu.taskmaster.common.dto.UserInfoDTO;
import net.czqu.taskmaster.common.response.ResponseResult;
import net.czqu.taskmaster.common.utils.HttpClientUtil;
import net.czqu.taskmaster.common.utils.JacksonUtils;
import net.czqu.taskmaster.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.czqu.taskmaster.common.constant.Headers.AUTHORIZATION_HEADER;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 21:35
 **/
public class JwtAuthenticationFilter extends OncePerRequestFilter {



    private final JwtService jwtService;


    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String jwt = getJwtFromRequest(request);
        if (jwt == null) {
            try {
                filterChain.doFilter(request, response);
                return;
            } catch (AccessDeniedException e) {
                throw e;
            }
        }

        try {
            String uid = jwtService.getUidFromToken(jwt);
            UserInfoDTO userInfoDTO=getUserInfoFromSSO(jwt,uid);
            UserDetails userDetails = getUserDetailsFromUserInfo(userInfoDTO);
            if (StringUtils.hasText(jwt)) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
                return;
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }
        filterChain.doFilter(request, response);


    }

    private String getJwtFromRequest(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION_HEADER);

    }

    private UserInfoDTO getUserInfoFromSSO(String token,String uid) throws IOException, URISyntaxException {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        headers.put(AUTHORIZATION_HEADER, token);
        params.put("uid", uid);
        String responseBody = HttpClientUtil.httpGet(jwtService.getSSOUrl()+"account/info", params, headers);
        ObjectMapper mapper = new ObjectMapper();
        ResponseResult<UserInfoDTO> responseResult = mapper.readValue(responseBody, new TypeReference<ResponseResult<UserInfoDTO>>() {});
        return (UserInfoDTO) responseResult.getData();
    }
    private UserDetails getUserDetailsFromUserInfo(UserInfoDTO userInfoDTO){
        CustomUserDetail customUserDetail = new CustomUserDetail(
                userInfoDTO.getUsername(), String.valueOf(userInfoDTO.getUid()),
                "",getAuthoritiesFromUserInfo(userInfoDTO));
        return customUserDetail;

    }

    private List<GrantedAuthority> getAuthoritiesFromUserInfo(UserInfoDTO userInfoDTO ) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("test"));
//        List<TmRole> roles = tmUserService.getRoleByUser(user);
//        for (TmRole role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        return authorities;
    }


}
