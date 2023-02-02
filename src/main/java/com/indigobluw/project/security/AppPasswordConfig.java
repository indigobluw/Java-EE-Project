package com.indigobluw.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppPasswordConfig {

    @Bean
    public PasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder(14); //standard är 10. Välj mellan 4-30. JU lägre desto snabbare login men osäkrare
    }
}
