package com.github.alexaegis.restaurant.kitchen;

public class FactoryProduct {

    private static FactoryProduct instance;

    /**
     * Constructor set to private
     */
    private FactoryProduct() {

    }

    /**
     * Gets the instance of the object
     *
     * @return the instance of the object
     */
    public static FactoryProduct getFactory() {

        if (instance == null) {

            synchronized(FactoryProduct.class) {

                if (instance == null) {
                    instance = new FactoryProduct();
                }
            }
        }
        return instance;
    }

    /**
     * Creates a new Drink, Water
     *
     * @return a Drink, Water
     */
    public Product createDrinkWater() {
        return new ProductDrinkWater("Water", 10, 100);
    }

    /**
     * Creates a new Food, Appetizer
     *
     * @return a Food, Appetizer
     */
    public Product createFoodAppetizer() {
        return new ProductFoodAppetizer("Appetizer", 6, 400);
    }

    /**
     * Creates a new Food, Main
     *
     * @return a Food, Main
     */
    public Product createFoodMain() {
        return new ProductFoodMain("Main", 7, 800);
    }

    /**
     * Creates a new Food, Dessert
     *
     * @return a Food, Dessert
     */
    public Product createFoodDessert() {
        return new ProductFoodDessert("Dessert", 8, 600);
    }

    /**
     * Overridden toString method
     *
     * @return the name of the factory
     */
    @Override
    public String toString() {
        return "Product Factory";
    }

    /**
     * Overridden hashCode method
     *
     * @return the id of the factory
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}