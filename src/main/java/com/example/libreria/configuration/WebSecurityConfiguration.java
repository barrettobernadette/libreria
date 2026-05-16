package com.example.libreria.configuration;

import com.example.libreria.security.dto.enums.UserPermission;
import com.example.libreria.security.dto.enums.UserRoles;
import com.example.libreria.security.filters.VerifyToken;
import com.example.libreria.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Autowired
    SecurityService securityService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
/*            configuration.addAllowedOrigin("https://google.com/*");*/
            return configuration;
        }))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/backoffice/*").hasRole(UserRoles.ADMINISTRATOR.name())
                        .requestMatchers("/backoffice/edit-user").hasAuthority(UserPermission.ADMINWRITE.getPermission())
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .addFilterAfter(new VerifyToken(securityService), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("dethu")
                        .password("pass")
                        .roles("ADMIN")
                        .build());
    }
}
