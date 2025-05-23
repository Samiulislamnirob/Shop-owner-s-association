package com.example.demo3;

public class ShopOwner {
    private String name;
    private String phone;
    private String email;
    private String shopName;

    public ShopOwner(String name, String phone, String email, String shopName) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.shopName = shopName;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getShopName() {
        return shopName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}

