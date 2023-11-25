package com.brief.marjane2.service;


import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.observer.Observer;
import com.brief.marjane2.observer.PromotionManager;
import com.brief.marjane2.repository.PromotionRespository;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService  {
    @Autowired
    private ResponsableRayonRepository responsableRayonRepository;

    @Autowired
    private PromotionRespository promotionRespository;

    @Autowired
    private PromotionManager promotionManager;


    public ResponseEntity<Promotion> create(Promotion promotion){
        try{
            Promotion promotion1 = promotionRespository.save(promotion);

            List<ResponsableRayon> responsableRayonList =  responsableRayonRepository.findBySubscribe(true);
            for(ResponsableRayon resp : responsableRayonList){
                promotionManager.addObserver(resp);
            }
            

            promotionManager.notifyObservers("Promotion from " + promotion1.getDateDebut() + "to " + promotion.getDateFin() + " has been created ");
            return ResponseEntity.ok( promotion1);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
