package com.brief.marjane2.observer;

import com.brief.marjane2.entity.ResponsableRayon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionManager  {

    @Autowired
    private EmailListener logginListener;




    private List<ResponsableRayon> responsableRayonList = new ArrayList<>();


    public PromotionManager(){
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setEmail("karim");
        responsableRayonList.add(responsableRayon);
        ResponsableRayon responsableRayon1 = new ResponsableRayon();
        responsableRayon1.setEmail("salah");
        responsableRayonList.add(responsableRayon1);

    }

    public void Subscribe(ResponsableRayon responsableRayon){
        responsableRayonList.add(responsableRayon);

    }
    public void unSubscribe(ResponsableRayon responsableRayon){
        responsableRayonList.remove(responsableRayon);
    }

    public void notifyResponsable(){
        for (ResponsableRayon resp : responsableRayonList ) {
           logginListener.Update(resp.getEmail());
        }
    }






}
