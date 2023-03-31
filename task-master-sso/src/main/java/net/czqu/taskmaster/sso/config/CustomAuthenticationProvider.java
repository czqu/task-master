package net.czqu.taskmaster.sso.config;


import net.czqu.taskmaster.sso.service.CustomUserDetailsServiceImpl;
import net.czqu.taskmaster.sso.service.TMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final CustomUserDetailsServiceImpl userDetailsService;

    private final TMUserService userService;

    @Autowired
    public CustomAuthenticationProvider(CustomUserDetailsServiceImpl userDetailsService, TMUserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String uid = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        CustomUserDetail userInfo = userDetailsService.loadUserByUsername(uid);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        boolean isValid = false;
        isValid = new BCryptPasswordEncoder().matches(password, userInfo.getPassword());
        if (!isValid) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}
