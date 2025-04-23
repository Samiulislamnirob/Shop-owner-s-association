package com.example.demo3;

public class Announcement {
    private String message;
    private String audience;
    private String date;

    public Announcement(String message, String audience, String date) {
        this.message = message;
        this.audience = audience;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getAudience() {
        return audience;
    }

    public String getDate() {
        return date;
    }
}
