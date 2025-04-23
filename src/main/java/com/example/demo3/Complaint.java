package com.example.demo3;

public class Complaint {
    private String memberName;
    private String type;
    private String details;
    private String status;

    public Complaint(String memberName, String type, String details, String status) {
        this.memberName = memberName;
        this.type = type;
        this.details = details;
        this.status = status;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
