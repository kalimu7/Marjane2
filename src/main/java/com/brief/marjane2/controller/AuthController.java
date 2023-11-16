package com.brief.marjane2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    @Autowired
    private JwtEncoder jwtencoder;

    /*public AuthController(JwtEncoder jwtEncoder){
        this.jwtencoder = jwtEncoder;

    }*/

    @PostMapping("/Token")
    public Map<String,String> JwtToken(Authentication authentication){
        Map<String,String> idToken = new HashMap<>();
        Instant instant = Instant.now();
        String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(authentication.getName())
                .issuedAt(instant)
                .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("role",roles)
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),jwtClaimsSet
        );

        String jwt = jwtencoder.encode(jwtEncoderParameters).getTokenValue();


        idToken.put("accessToken",jwt);
        return idToken;
    }

    @PostMapping("/auth/login")
    public Map<String,String> login(String username,String password){
        Authentication authentication = null;
        Map<String,String> idToken = new HashMap<>();
        Instant instant = Instant.now();
        String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(authentication.getName())
                .issuedAt(instant)
                .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("role",roles)
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),jwtClaimsSet
        );

        String jwt = jwtencoder.encode(jwtEncoderParameters).getTokenValue();


        idToken.put("accessToken",jwt);
        return idToken;
    }





}
