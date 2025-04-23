package com.example.demo3;

public class Feedback {
    private String shopName;
    private String feedback;
    private int rating;
    private boolean reviewed;

    public Feedback(String shopName, String feedback, int rating) {
        this.shopName = shopName;
        this.feedback = feedback;
        this.rating = rating;
        this.reviewed = false;
    }

    public String getShopName() {
        return shopName;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getRating() {
        return rating;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }
}
