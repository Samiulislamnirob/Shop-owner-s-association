package com.example.demo3;

public class ScheduledTask {
    private final String task;
    private final String area;
    private final String date;
    private final String time;
    private final String staff;

    public ScheduledTask(String task, String area, String date, String time, String staff) {
        this.task = task;
        this.area = area;
        this.date = date;
        this.time = time;
        this.staff = staff;
    }

    public String getTask() {
        return task;
    }

    public String getArea() {
        return area;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStaff() {
        return staff;
    }
}



