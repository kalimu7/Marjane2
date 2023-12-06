package com.brief.marjane2.config;


import com.nimbusds.jose.jwk.source.ImmutableSecret;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import javax.crypto.spec.SecretKeySpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class securityconfig {

    @Value("${jwt.key}")
    private String jwtKey;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(ar->ar.requestMatchers("/Center/**").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/Responsable/**").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/Caissier/**").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/Client/**").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/test").hasAuthority("ROLE_adminGenerale"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/auth/login").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/auth/login").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/profile").authenticated())

                .authorizeHttpRequests( auth -> auth
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(withDefaults()))

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())

                .build();
    }

    @Resource
    private AdminGeneraleDetailsService adminGeneraleDetailsService;

    /*@Resource
    private AdminCenterDetailsService adminCenterDetailsService;
    */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setPasswordEncoder(PasswordEncoder());
            daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }





    /*@Bean
    public InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("karim").password(PasswordEncoder().encode("karim")).authorities("adminGenerale").build(),
                User.withUsername("ahmed").password("{noop}password").authorities("adminCentre").build(),
                User.withUsername("kamal").password("{noop}password").authorities("ResponsableRayon").build()

        );
    }*/


    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
    }







    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec originalKey = new SecretKeySpec(this.jwtKey.getBytes(), "HS512");
        return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS512).build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
