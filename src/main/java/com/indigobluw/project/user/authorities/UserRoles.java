package com.indigobluw.project.user.authorities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.indigobluw.project.user.authorities.UserPermissions.*;

//This isn't a must, can use String Admin instead
public enum UserRoles {
    ADMIN (Set.of(ADMIN_CAN_READ, ADMIN_CAN_DELETE)), //innan import på rad 4 fick man skriva permissions.admin_can_read
    USER(Set.of(USER_CAN_READ));

    /*private final String description;
    Roles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }*/

    private final Set<UserPermissions> permissionsSet;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissionsSet = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissionsSet;
    }

//Under denna kommentar ser annurlunda ut i sliden men liknande som hans kod från github #9 slide 28
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissionsSet =  getPermissions().stream().map(
                index -> new SimpleGrantedAuthority(index.getUserPermission())
        ).collect(Collectors.toSet());
        permissionsSet.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissionsSet;
    }
}
