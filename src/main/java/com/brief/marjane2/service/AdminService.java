package com.brief.marjane2.service;

import com.brief.marjane2.entity.AdminGeneral;
import com.brief.marjane2.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    private  adminRepository adminrepository;

    @Autowired
    public AdminService(adminRepository adminrepository) {
        this.adminrepository = adminrepository;
    }

    public  AdminGeneral login(String email){
        AdminGeneral adminGeneral = adminrepository.findByEmail(email);

        return adminGeneral;
    }


}
