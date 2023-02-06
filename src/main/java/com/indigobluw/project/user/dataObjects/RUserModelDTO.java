package com.indigobluw.project.user.dataObjects;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record RUserModelDTO(String username,
                            Collection<? extends GrantedAuthority> authorities
) {

}
