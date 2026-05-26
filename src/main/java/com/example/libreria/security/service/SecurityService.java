package com.example.libreria.security.service;

import com.example.libreria.entity.User;
import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class SecurityService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;


    public void login(UserAccessData userAccessData, HttpServletResponse httpServletResponse){
        User user = userService.getUser(userAccessData.getUsername());
        boolean isPswCorrect = passwordEncoder.matches(userAccessData.getPassword(), user.getPassword());
        if(!isPswCorrect) {
            throw new RuntimeException("Password Errata");
        }
        Cookie cookie = new Cookie("jwt",jwtService.generateJwt(user));
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 *60);
        cookie.setAttribute("SameSite","None");
        httpServletResponse.addCookie(cookie);
    }

    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt",null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setAttribute("SameSite","None");

        response.addCookie(cookie);

    }
}
