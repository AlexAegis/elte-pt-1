package com.github.alexaegis.restaurant.kitchen;

class ProductDrink extends Product {

    ProductDrink() {

    }

    ProductDrink(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }
}