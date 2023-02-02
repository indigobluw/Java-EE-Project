package com.indigobluw.project.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import static com.indigobluw.project.security.UserPermissions.*;

public enum UserRoles {
    ADMIN (List.of(ADMIN_CAN_READ, ADMIN_CAN_DELETE)), //innan import på rad 4 fick man skriva permissions.admin_can_read
    USER(List.of(USER_CAN_READ));

    /*private final String description;
    Roles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }*/

    private final List<UserPermissions> permissionsList;

    UserRoles(List<UserPermissions> permissionsList) {
        this.permissionsList = permissionsList;
    }

    public List<UserPermissions> getPermissionsList() {
        return permissionsList;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> permissions =  new ArrayList<>(getPermissionsList().stream().map(
                index -> new SimpleGrantedAuthority(index.getUserPermissions())
        ).toList());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name())); //"ROLE_" + this.name lektion 7 1:58:00

        return permissions;
    }
}
