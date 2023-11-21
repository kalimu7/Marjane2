package com.brief.marjane2.service;


import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.repository.PromotionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    @Autowired
    private PromotionRespository promotionRespository;

    public ResponseEntity create(Promotion promotion){
        try{
            return ResponseEntity.ok( promotionRespository.save(promotion));
        }catch (Exception e){
            return new ResponseEntity<>("not created", HttpStatus.BAD_REQUEST);
        }
    }

}
