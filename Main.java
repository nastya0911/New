package com.yourdomain.trafficnotification;

import java.util.ArrayList; // Импортируем ArrayList
import java.util.List;      // Импортируем List

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
    }
}

class TrafficPost implements NotificationService.Observer {
    private String name;

    public TrafficPost(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил уведомление: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        TrafficPost post1 = new TrafficPost("Пост 1");
        TrafficPost post2 = new TrafficPost("Пост 2");

        notificationService.registerObserver(post1);
        notificationService.registerObserver(post2);

        notificationService.sendNotification("Проверка документов на дороге!");
    }
}

