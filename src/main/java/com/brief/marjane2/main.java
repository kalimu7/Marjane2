package com.brief.marjane2;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class main {

    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {

        main main = new main();
        PasswordEncoder p = main.PasswordEncoder();
        System.out.println( p.encode("admin") );

    }

}
