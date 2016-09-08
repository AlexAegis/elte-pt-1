package com.github.alexaegis.restaurant.kitchen;

public abstract class Product {

    private String name;
    private int value;
    private int quality;

    Product() {

    }

    Product(String name) {
        this.setName(name);
    }

    Product(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    public int getQuality() {
        return quality;
    }

    void setQuality(int quality) {
        this.quality = quality;
    }
}