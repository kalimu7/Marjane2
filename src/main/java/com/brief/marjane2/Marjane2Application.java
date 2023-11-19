package com.brief.marjane2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EntityScan(basePackages = "com.brief.marjane2.entity")
@EnableJpaRepositories(basePackages = "com.brief.marjane2.repository" )
public class Marjane2Application {




    public static void main(String[] args) {


        SpringApplication.run(Marjane2Application.class, args);

    }

}
