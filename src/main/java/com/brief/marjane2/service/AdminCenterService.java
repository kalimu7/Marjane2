package com.brief.marjane2.service;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCenterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminCenterRepository adminCenterRepository;
    public void  create(AdminCentre adminCentre){
            adminCentre.setPassword(passwordEncoder.encode(adminCentre.getPassword()));
            adminCenterRepository.save(adminCentre);

    }

    public List<AdminCentre> fetchall(){
        return adminCenterRepository.findAll();
    }

    public Optional<AdminCentre> findByid(int id){
        return adminCenterRepository.findById(id);
    }

    public void Update(AdminCentre adminCentre1){
         AdminCentre adminCentre =  adminCenterRepository.save(adminCentre1);
    }

    public void delete(AdminCentre adminCentre){
        adminCenterRepository.delete(adminCentre);
    }

}
