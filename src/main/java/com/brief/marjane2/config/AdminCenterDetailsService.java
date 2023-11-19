/*package com.brief.marjane2.config;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminCenterDetailsService implements UserDetailsService {

    private AdminCenterRepository adminCenterRepository;
    @Autowired
    public AdminCenterDetailsService(AdminCenterRepository adminCenterRepository){
        this.adminCenterRepository = adminCenterRepository;

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminCentre adminCentre = adminCenterRepository.findByEmail(username);
        if(adminCentre == null){
            throw new UsernameNotFoundException("no user with these credentials");
        }
        UserDetails user = User.withUsername(adminCentre.getEmail()).password(adminCentre.getPassword()).authorities("adminCenter").build();
        return user;
    }
}
*/