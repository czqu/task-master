package net.czqu.taskmasterjwt.service;


import net.czqu.taskmasterdao.pojo.TmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 20:54
 **/
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TMUserService tmUserService;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        TmUser user = tmUserService.getUserByUid(uid);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        // 加盐密码验证
        String encodedPassword = encodePassword(user.getPasswordSalt(), user.getPasswordHash());
        return new User(
                user.getUid(), encodedPassword, getAuthorities(user));
    }

    private List<GrantedAuthority> getAuthorities(TmUser user) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("test"));
//        List<TmRole> roles = tmUserService.getRoleByUser(user);
//        for (TmRole role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        return authorities;
    }

    private String encodePassword(String salt, String password) {
        // 在这里使用加盐的方式对密码进行哈希计算
        String saltedPassword = password + salt;
        return new BCryptPasswordEncoder().encode(saltedPassword);
    }
}

