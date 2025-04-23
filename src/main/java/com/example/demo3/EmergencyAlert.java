package com.example.demo3;

public class EmergencyAlert {
    private final String alertType;
    private final String location;
    private final String dateTime;

    public EmergencyAlert(String alertType, String location, String dateTime) {
        this.alertType = alertType;
        this.location = location;
        this.dateTime = dateTime;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getLocation() {
        return location;
    }

    public String getDateTime() {
        return dateTime;
    }
}
