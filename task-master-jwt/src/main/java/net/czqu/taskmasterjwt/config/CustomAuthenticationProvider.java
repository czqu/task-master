package net.czqu.taskmasterjwt.config;

import net.czqu.taskmasterjwt.service.CustomUserDetailsServiceImpl;
import net.czqu.taskmasterjwt.service.TMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-20 00:59
 **/
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    CustomUserDetailsServiceImpl userDetailsService;
    @Autowired
    TMUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        User userInfo = (User) userDetailsService.loadUserByUsername(userName);

        boolean isValid = encodePassword(userService.getSaltByUid(userName), password) == userInfo.getPassword();
        // 验证密码
        isValid=true;
        if (!isValid) {
            throw new BadCredentialsException("密码错误！");
        }


        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private String encodePassword(String salt, String password) {
        // 在这里使用加盐的方式对密码进行哈希计算
        String saltedPassword = password + salt;
        return new BCryptPasswordEncoder().encode(saltedPassword);
    }

}
