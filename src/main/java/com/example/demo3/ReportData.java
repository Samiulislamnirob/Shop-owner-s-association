package com.example.demo3;

public class ReportData {
    private String type;
    private String member;
    private String date;
    private String content;

    public ReportData(String type, String member, String date, String content) {
        this.type = type;
        this.member = member;
        this.date = date;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getMember() {
        return member;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
