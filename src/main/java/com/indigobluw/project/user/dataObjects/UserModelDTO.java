package com.indigobluw.project.user.dataObjects;

import com.indigobluw.project.user.UserModel;
import com.indigobluw.project.user.UserModelService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//Transfer data securely
//vad vill vi visa upp för användaren

public class UserModelDTO {
    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UserModelDTO(UserModel userModel) {
        this.username = userModel.getUsername();
        this.authorities = userModel.getAuthorities();
    }

}
