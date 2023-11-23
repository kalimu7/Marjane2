package com.brief.marjane2.config;

import com.brief.marjane2.entity.AdminGeneral;
import com.brief.marjane2.repository.adminRepository;
import com.brief.marjane2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        if(adminGeneral == null){
            throw new UsernameNotFoundException("no user with these credentials");
        }
        UserDetails user = User.withUsername(adminGeneral.getEmail()).password(adminGeneral.getPassword()).authorities("ROLE_adminGenerale").build();
        return user;
    }



}
