package com.cos.security1.config.auth;

import com.cos.security1.model.UserData;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserData userData;
    private Map<String, Object> attributes;


    public UserData getUserData() {
        return userData;
    }

    //일반 로그인 생성자
    public PrincipalDetails(UserData userData) {
        this.userData = userData;
    }

    //oauth로그인 생성자
    public PrincipalDetails(UserData userData, Map<String, Object> attributes) {
        this.userData = userData;
        this.attributes=attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(userData.getRole()));
        return roles;
    }

    @Override
    public String getPassword() {
        return userData.getPassword();
    }

    @Override
    public String getUsername() {
        return userData.getUsername();
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


}
