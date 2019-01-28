package com.mygoosa.mygoosa.Models;

public class Album {
    private String name;
    private int thumbnail;

    private String price;

    private String strikePrice;
    private String discountPercent;
    private String desc;

    public Album() {
    }

    public Album(String name,int thumbnail,String price,String strikePrice,String discountPercent,String desc) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.price=price;
        this.strikePrice=strikePrice;
        this.discountPercent=discountPercent;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price=price;
    }

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice=strikePrice;
    }

    public String getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent=discountPercent;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc=desc;
    }


}
