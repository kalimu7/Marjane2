package com.brief.marjane2.service;

import com.brief.marjane2.entity.Caissier;
import com.brief.marjane2.repository.CaissierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CaissierService {

    @Autowired
    private CaissierRepository caissierRepository;

    public ResponseEntity create(Caissier caissier){
        try {
            Caissier caissier1 = caissierRepository.save(caissier);
            return ResponseEntity.ok( caissier1 );

        }catch (Exception e){
            return new ResponseEntity<>("not cerated", HttpStatus.OK);
        }
    }

}
