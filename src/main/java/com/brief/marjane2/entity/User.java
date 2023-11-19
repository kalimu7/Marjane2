package com.brief.marjane2.entity;


import com.brief.marjane2.enums.roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRR;

    @Column(name = "Email", unique = true)
    private String Email;

    @Enumerated(EnumType.STRING)
    private roles role;

    @Column (name = "Password")
    private String Password;


}
