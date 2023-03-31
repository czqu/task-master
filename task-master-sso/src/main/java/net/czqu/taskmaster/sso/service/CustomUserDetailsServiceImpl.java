package net.czqu.taskmaster.sso.service;


import net.czqu.taskmaster.sso.config.CustomUserDetail;
import net.czqu.taskmaster.dao.pojo.TmUser;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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


    private TMUserService tmUserService;


    @Autowired
    public CustomUserDetailsServiceImpl(TMUserService tmUserService) {
        this.tmUserService = tmUserService;

    }

    @Override
    public CustomUserDetail loadUserByUsername(String inputuid) throws UsernameNotFoundException {
        if (!NumberUtils.isDigits(inputuid)) {
            return null;
        }
        int uid=Integer.parseInt(inputuid);
        TmUser user = tmUserService.getUserByUid(uid);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return  new CustomUserDetail(user.getUsername(), String.valueOf(uid), user.getPassword(), getAuthorities(user));
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

}

