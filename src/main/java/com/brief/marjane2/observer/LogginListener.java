package com.brief.marjane2.observer;

import org.springframework.stereotype.Component;

@Component
public class LogginListener implements PromotionListener{
    @Override
    public void Update(String email) {
        System.out.println("new promotion is created and receieved " + email);
    }
}
