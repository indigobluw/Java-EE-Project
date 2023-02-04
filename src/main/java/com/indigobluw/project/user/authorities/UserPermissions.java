package com.indigobluw.project.user.authorities;

public enum UserPermissions {

    ADMIN_CAN_READ("ADMIN:READ"),
    ADMIN_CAN_DELETE("ADMIN:DELETE"),
    USER_CAN_READ("USER:READ");

    private final String userPermission;

    UserPermissions(String userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserPermission() {
        return userPermission;
    }
}
