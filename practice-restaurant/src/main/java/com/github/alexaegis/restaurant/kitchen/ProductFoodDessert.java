package com.github.alexaegis.restaurant.kitchen;

class ProductFoodDessert extends ProductFood {

    ProductFoodDessert() {

    }

    ProductFoodDessert(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }
}