package com.brief.marjane2.service;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(AdminCentre adminCentre){
            adminCentre.setPassword(passwordEncoder.encode(adminCentre.getPassword()));
            return ResponseEntity.ok(adminCenterRepository.save(adminCentre));

    }

    public List<AdminCentre> fetchall(){
        return adminCenterRepository.findAll();
    }

    public Optional<AdminCentre> findByid(int id){
        return adminCenterRepository.findById(id);
    }

    public ResponseEntity<String> Update(AdminCentre adminCentre1){
        try {
            adminCenterRepository.save(adminCentre1);
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not updated",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(AdminCentre adminCentre){
        try{
            adminCenterRepository.delete(adminCentre);
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not deleted",HttpStatus.BAD_REQUEST);
        }

    }

}
