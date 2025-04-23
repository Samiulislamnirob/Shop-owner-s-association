package com.example.demo3;

public class MaintenanceReportEntry {
    private final String date;
    private final String task;
    private final String area;
    private final String status;
    private final String staff;

    public MaintenanceReportEntry(String date, String task, String area, String status, String staff) {
        this.date = date;
        this.task = task;
        this.area = area;
        this.status = status;
        this.staff = staff;
    }

    public String getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public String getArea() {
        return area;
    }

    public String getStatus() {
        return status;
    }

    public String getStaff() {
        return staff;
    }
}
