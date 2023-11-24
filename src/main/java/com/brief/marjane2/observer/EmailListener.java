package com.brief.marjane2.observer;

import org.springframework.stereotype.Component;

@Component
public class EmailListener implements PromotionListener{
    @Override
    public void Update(String email) {
        System.out.println("this reveceid by email " + email);
    }
}
