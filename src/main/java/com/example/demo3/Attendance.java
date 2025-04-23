package com.example.demo3;

public class Attendance {
    private String memberName;
    private String status; // "Present" or "Absent"

    public Attendance(String memberName, String status) {
        this.memberName = memberName;
        this.status = status;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
