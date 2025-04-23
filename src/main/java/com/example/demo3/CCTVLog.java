package com.example.demo3;

public class CCTVLog {
    private final String zone;
    private final String timestamp;
    private final String notes;

    public CCTVLog(String zone, String timestamp, String notes) {
        this.zone = zone;
        this.timestamp = timestamp;
        this.notes = notes;
    }

    public String getZone() {
        return zone;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNotes() {
        return notes;
    }
}
