package com.brief.marjane2.service;


import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.observer.PromotionManager;
import com.brief.marjane2.repository.PromotionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    @Autowired
    private PromotionRespository promotionRespository;

    @Autowired
    private PromotionManager promotionManager;

    public ResponseEntity<Promotion> create(Promotion promotion){
        try{
            Promotion promotion1 = promotionRespository.save(promotion);
            promotionManager.notifyResponsable();
            return ResponseEntity.ok( promotion1);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
