package com.brief.marjane2.observer;

public interface Publisher {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);



}
