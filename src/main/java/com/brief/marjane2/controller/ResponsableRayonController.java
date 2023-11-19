package com.brief.marjane2.controller;


import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Responsable")
public class ResponsableRayonController {
    
    @Autowired
    private ResponsableRayonRepository responsableRayonRepository;

    @PostMapping("/rayon")
   public ResponseEntity<String> create(@RequestBody ResponsableRayon responsableRayon){
        try {
            responsableRayonRepository.save(responsableRayon);
            return  new ResponseEntity<>("created", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not created",HttpStatus.BAD_REQUEST);
        }
   }

}
