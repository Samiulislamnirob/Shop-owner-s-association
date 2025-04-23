package com.example.demo3;

public class VendorRating {
    private String vendorName;
    private int rating;

    public VendorRating(String vendorName, int rating) {
        this.vendorName = vendorName;
        this.rating = rating;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
