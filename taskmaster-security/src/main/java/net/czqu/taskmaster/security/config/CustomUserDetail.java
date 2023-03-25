package net.czqu.taskmaster.security.config;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-25 23:30
 **/

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetail implements UserDetails {

    private final String username;
    private final String uid;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetail(String username, String uid, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.uid = uid;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(getUid());
    }
    public String getUserNickName(){
        return  username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getUid() {
        return uid;
    }
}

