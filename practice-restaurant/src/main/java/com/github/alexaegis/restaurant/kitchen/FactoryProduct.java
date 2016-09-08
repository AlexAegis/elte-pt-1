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
     * Creates a new Drink
     *
     * @return a Drink
     */
    public Product createDrink() {
        return new ProductDrink();
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