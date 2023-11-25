package com.brief.marjane2.observer;

import com.brief.marjane2.entity.ResponsableRayon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionManager implements Publisher {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {



        for (Observer obs : observers){
            if(obs instanceof ResponsableRayon){

                obs.update(message,((ResponsableRayon) obs).getEmail());

            }

        }
    }
}
