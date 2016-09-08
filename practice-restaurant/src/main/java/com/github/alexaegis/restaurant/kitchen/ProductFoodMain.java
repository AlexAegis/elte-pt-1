package com.github.alexaegis.restaurant.kitchen;

class ProductFoodMain extends ProductFood {

    ProductFoodMain() {

    }

    ProductFoodMain(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }
}