package net.czqu.taskmaster.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.czqu.taskmaster.common.dto.AuthDTO;
import net.czqu.taskmaster.common.dto.JwtAuthenticationDTO;
import net.czqu.taskmaster.common.dto.UserInfoDTO;
import net.czqu.taskmaster.common.response.ResponseResult;
import net.czqu.taskmaster.common.utils.HttpClientUtil;
import net.czqu.taskmaster.common.utils.JacksonUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static net.czqu.taskmaster.common.constant.Headers.AUTHORIZATION_HEADER;
import static net.czqu.taskmaster.config.SSO_BASE_URL;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-31 23:10
 **/
@Slf4j
public class LoginService {

    private static final String LOGIN_URL = SSO_BASE_URL + "/api/auth/login";
    private static final String GET_USER_INFO_URL = SSO_BASE_URL + "/account/info";
    private String token;

    public void login(String username, String password) throws IOException, URISyntaxException {
        Map<String, String> headers = new HashMap<>();
        // Map<String, String> params = new HashMap<>();
        headers.put("Content-Type", "application/json");
        AuthDTO authDTO = new AuthDTO();
        authDTO.setUid(username);
        authDTO.setPassword(password);
        String responseBody = HttpClientUtil.httpPost(LOGIN_URL, null, headers, JacksonUtils.serialize(authDTO));
        ObjectMapper mapper = new ObjectMapper();
        ResponseResult<JwtAuthenticationDTO> responseResult = mapper.readValue(responseBody, new TypeReference<ResponseResult<JwtAuthenticationDTO>>() {
        });
        if("".equals(responseResult.getCode()))
        {
            token = responseResult.getData().getToken();
        }

    }
    public UserInfoDTO getUserInfo(String uid) throws IOException, URISyntaxException {
        if(StringUtils.isEmpty(token)){
            log.error("token为空");
            return null;
        }
        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", token);
        params.put("uid", uid);
        String responseBody = HttpClientUtil.httpGet(GET_USER_INFO_URL,params,headers);
        ObjectMapper mapper = new ObjectMapper();
        ResponseResult<UserInfoDTO> responseResult = mapper.readValue(responseBody, new TypeReference<ResponseResult<UserInfoDTO>>() {
        });
        return responseResult.getData();

    }

}
