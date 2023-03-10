package com.indigobluw.project.user.authorities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.indigobluw.project.user.authorities.UserPermissions.*;

public enum UserRoles {
    ADMIN(Set.of(ADMIN_CAN_READ,
            ADMIN_CAN_DELETE,
            ADMIN_CAN_WRITE,
            ADMIN_CAN_POST)),
    USER(Set.of(USER_CAN_READ,
            USER_CAN_WRITE,
            USER_CAN_POST));

    private final Set<UserPermissions> permissionsList;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissionsList = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissionsList;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {

        Set<SimpleGrantedAuthority> permissionsSet = getPermissions().stream().map(
                index -> new SimpleGrantedAuthority(index.getUserPermission())
        ).collect(Collectors.toSet()); //recap video 1:59:36 new Hashset

        permissionsSet.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissionsSet;
    }
}
