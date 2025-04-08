package com.yourdomain.trafficnotification;

import java.util.ArrayList; // Импортируем ArrayList
import java.util.List;      // Импортируем List





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

