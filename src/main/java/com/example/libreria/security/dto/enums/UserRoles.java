package com.example.libreria.security.dto.enums;

import org.apache.catalina.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRoles {
    ADMINISTRATOR(
            Set.of(UserPermission.ADMINGET,UserPermission.ADMINWRITE,UserPermission.USERGET, UserPermission.USERWRITE)),
    SUBADMINISTRATOR(Set.of(UserPermission.ADMINGET, UserPermission.USERGET, UserPermission.USERWRITE)),
    USER(Set.of(UserPermission.USERGET, UserPermission.USERWRITE));

    private final Set<UserPermission> permissions;

    private UserRoles(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> gSimpleGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = this.permissions
                .stream()
                .map(el -> new SimpleGrantedAuthority(el.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return authorities;
    }
}
