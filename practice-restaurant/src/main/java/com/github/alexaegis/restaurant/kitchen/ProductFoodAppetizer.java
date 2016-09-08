package com.github.alexaegis.restaurant.kitchen;

class ProductFoodAppetizer extends ProductFood {

    ProductFoodAppetizer() {

    }

    ProductFoodAppetizer(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }
}