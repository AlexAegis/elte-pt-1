package com.github.alexaegis.restaurant.kitchen;

class ProductDrinkWater extends ProductDrink {

    ProductDrinkWater() {

    }

    public ProductDrinkWater(String name, int quality, int value) {
        this.setName(name);
        this.setValue(value);
        this.setQuality(quality);
    }
}