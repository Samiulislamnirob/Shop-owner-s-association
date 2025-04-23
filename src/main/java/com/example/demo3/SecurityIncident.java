package com.example.demo3;

public class SecurityIncident {
}package com.example.demo3;

public class SecurityIncident {
    private final String incidentType;
    private final String location;
    private final String time;
    private final String description;

    public SecurityIncident(String incidentType, String location, String time, String description) {
        this.incidentType = incidentType;
        this.location = location;
        this.time = time;
        this.description = description;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}

