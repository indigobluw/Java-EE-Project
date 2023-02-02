package com.indigobluw.project.security;

public enum UserPermissions {

    ADMIN_CAN_READ("ADMIN:READ"),
    ADMIN_CAN_DELETE("ADMIN:DELETE"),
    USER_CAN_READ("USER:READ");

    private final String userPermissions;

    UserPermissions(String userPermissions) {
        this.userPermissions = userPermissions;
    }

    public String getUserPermissions() {
        return userPermissions;
    }
}
