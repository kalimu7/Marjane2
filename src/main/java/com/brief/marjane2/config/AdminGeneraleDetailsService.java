package com.brief.marjane2.config;

import com.brief.marjane2.entity.AdminGeneral;
import com.brief.marjane2.repository.adminRepository;
import com.brief.marjane2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdminGeneraleDetailsService implements UserDetailsService {

    private  adminRepository adminrepository;

    @Autowired
    public AdminGeneraleDetailsService(adminRepository adminrepository) {
        this.adminrepository = adminrepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminGeneral adminGeneral = adminrepository.findByEmail(username);
        if (adminGeneral == null) {
            throw new UsernameNotFoundException("no user with these credentials");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin adminGeneram"));


        UserDetails user = User.withUsername(adminGeneral.getEmail())
                .password(adminGeneral.getPassword())
                .authorities(authorities)
                .build();
        return user;
    }



}
