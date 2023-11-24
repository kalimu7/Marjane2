package com.brief.marjane2.entity;


import com.brief.marjane2.enums.roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public  class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "email", unique = true)
    @NonNull
    private String email;



    @Column (name = "password")
    @NonNull
    private String password;


}
