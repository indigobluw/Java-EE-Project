package com.indigobluw.project.security;

import com.indigobluw.project.user.UserModelService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //enables @PreAuthorize
public class AppSecurityConfig {

    private final AppPasswordConfig bcrypt;
    private final UserModelService userModelService;

    @Autowired
    public AppSecurityConfig(AppPasswordConfig bcrypt, UserModelService userModelService) {
        this.bcrypt = bcrypt;
        this.userModelService = userModelService;
    }

    /* @Bean
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
    }*/

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
                AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
            }

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

            }
        };
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/", "/home", "/aboutus", "/error", "/login", "/test/**", "/register", "/static/**").permitAll() //Test encode är här tillfälligt lektion 8 2:17:40
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/homeuser", "/list").hasRole("USER")
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(formLogin -> formLogin
                                .loginPage("/login")
                        //.successHandler(myAuthenticationSuccessHandler())
                )
                .rememberMe(rememberMe -> rememberMe
                        .rememberMeParameter("remember-me")
                        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                        .userDetailsService(userModelService)
                        .key("key")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                )
                .authenticationProvider(authenticationOverride());

        return http.build();
    }

    @Autowired
    public DaoAuthenticationProvider authenticationOverride() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userModelService);
        provider.setPasswordEncoder(bcrypt.bCryptPasswordEncoder());

        return provider;
    }
}
