package com.indigobluw.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails therese = User.withDefaultPasswordEncoder()
                .username("therese")
                .password("1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(therese); //användare försvinner efter reset app

    }
}
