package com.example.libreria.security.dto.enums;

public enum UserPermission {
    ADMINGET("admin:get"),
    ADMINWRITE("admin:write"),
    USERGET("user:get"),
    USERWRITE("user:write");

    private final String permission;

    private UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
