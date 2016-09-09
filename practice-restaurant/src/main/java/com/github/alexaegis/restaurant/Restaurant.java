package com.github.alexaegis.restaurant;

public abstract class Restaurant {

    String name;

    Restaurant() {

    }

    Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}