package com.course.records.model;

public class Stock {
    private String name;
    private String artist;
    private Format format;
    private double price;
    private Shop shop;

    public Stock(String name, String artist, Format format, double price, Shop shop) {
        this.name = name;
        this.artist = artist;
        this.price = price;
        this.shop = shop;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
