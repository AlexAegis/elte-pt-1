package com.github.alexaegis.restaurant;

public class FactoryRestaurant {

    private static FactoryRestaurant instance;

    /**
     * Constructor set to private
     */
    private FactoryRestaurant() {

    }

    /**
     * Gets the instance of the object
     *
     * @return the instance of the object
     */
    public static FactoryRestaurant getFactory() {

        if (instance == null) {

            synchronized(FactoryRestaurant.class) {

                if (instance == null) {
                    instance = new FactoryRestaurant();
                }
            }
        }
        return instance;
    }

    /**
     * Creates a new Restaurant Alpha
     *
     * @return a Restaurant
     */
    public Restaurant createRestaurantAlpha() {
        return new RestaurantAlpha("Alpha");
    }

    /**
     * Overridden toString method
     *
     * @return the name of the factory
     */
    @Override
    public String toString() {
        return "Restaurant Factory";
    }

    /**
     * Overridden equals method
     *
     * @return true if its similar to the other object
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof FactoryRestaurant && this.toString().equals(obj.toString());
    }

    /**
     * Overridden hashCode method
     *
     * @return the id of the factory
     */
    @Override
    public int hashCode() {
        return 10;
    }
}