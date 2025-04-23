
package com.example.demo3;

public class MaintenanceRequest {
    private String shopName;
    private String issueType;
    private String description;
    private String urgencyLevel;

    public MaintenanceRequest(String shopName, String issueType, String description, String urgencyLevel) {
        this.shopName = shopName;
        this.issueType = issueType;
        this.description = description;
        this.urgencyLevel = urgencyLevel;
    }

    public String getShopName() {
        return shopName;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getDescription() {
        return description;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }
}



