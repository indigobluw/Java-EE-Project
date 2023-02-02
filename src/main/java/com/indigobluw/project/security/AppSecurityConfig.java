package com.indigobluw.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //enables @PreAuthorize
public class AppSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        //the following ppl is for debugging ONLY
        UserDetails therese = User.withDefaultPasswordEncoder()
                .username("therese")
                .password("1234")
                //.roles("ADMIN") .roles tar bara in en sträng
                .authorities(UserRoles.ADMIN.getGrantedAuthorities()) //therese verkar fortfarande inte ha permission att se admin sidan trots att hen är admin
                .build();

        UserDetails jesper = User.withDefaultPasswordEncoder()
                .username("jesper")
                .password("1234")
                .authorities(UserRoles.USER.getGrantedAuthorities()) //therese verkar fortfarande inte ha permission att se admin sidan trots att hen är admin
                .build();

        return new InMemoryUserDetailsManager(therese, jesper); //användare försvinner efter reset app
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/", "/error", "/login", "/test/encode").permitAll() //Test encode är här tillfälligt lektion 8 2:17:40
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return http.build();
    }
}
