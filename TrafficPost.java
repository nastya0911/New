package com.yourdomain.trafficnotification;

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
