package com.yourdomain.trafficnotification;

import java.util.ArrayList;
import java.util.List;

class NotificationService {
    interface Observer {
        void update(String message);
    }

    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void sendNotification(String message) {
        notifyObservers(message);
    }}
