package com.example.libreria.security.filters;

import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.security.dto.enums.UserRoles;
import com.example.libreria.security.service.SecurityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class VerifyToken extends OncePerRequestFilter {

    private SecurityService securityService;

    public VerifyToken(SecurityService securityService) {
        this.securityService = securityService;
    }
    @Override
    protected void initBeanWrapper(BeanWrapper bw) throws BeansException {
        super.initBeanWrapper(bw);
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
        String uri = request.getRequestURI();
        return  uri != null && uri.equals("/auth/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        Boolean isAuthorizationHeaderPresent = authorizationHeader != null && authorizationHeader.startsWith("Bearer ");
        if (isAuthorizationHeaderPresent) {
            String jwt = authorizationHeader.substring(7);

            // Validate token and generate authentication holder
            Authentication authentication = validateToken(jwt);
            // Set authentication context
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private Authentication validateToken(String jwt) throws ServletException {
        Claims claims = null;
        JwtParser jwtParser = Jwts.parser().verifyWith(securityService.signingKey()).build();
        try {
            claims = jwtParser.parseSignedClaims(jwt).getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            throw new ServletException();
        }

        String subject = claims.getSubject();

        UserAccessData user = new UserAccessData();
        user.setUsername("admin");
        user.setUserRoles(UserRoles.ADMINISTRATOR);
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        if (subject.equals("admin")) {
            grantedAuthorities.addAll(user.getUserRoles().gSimpleGrantedAuthorities());
        } else {
            grantedAuthorities.addAll(UserRoles.USER.gSimpleGrantedAuthorities());
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                subject,
                null,
                grantedAuthorities);
        return authentication;
    }
}
