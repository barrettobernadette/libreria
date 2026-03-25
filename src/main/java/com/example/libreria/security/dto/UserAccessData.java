package com.example.libreria.security.dto;

import com.example.libreria.security.dto.enums.UserRoles;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccessData {
    private String username;
    private String password;
    private UserRoles userRoles;
}
