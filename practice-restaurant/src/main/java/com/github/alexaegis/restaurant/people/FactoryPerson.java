package com.github.alexaegis.restaurant.people;

public class FactoryPerson {

    private static FactoryPerson instance;

    /**
     * Constructor set to private
     */
    private FactoryPerson() {

    }

    /**
     * Gets the instance of the object
     *
     * @return the instance of the object
     */
    public static FactoryPerson getFactory() {

        if (instance == null) {

            synchronized(FactoryPerson.class) {

                if (instance == null) {
                    instance = new FactoryPerson();
                }
            }
        }
        return instance;
    }

    /**
     * Creates a new Guest
     *
     * @return a Guest
     */
    public Person createPersonGuest() {
        return new PersonGuest("Guest");
    }

    /**
     * Creates a new Chef
     *
     * @return a Chef
     */
    public Person createPersonChef() {
        return new PersonChef("Chef");
    }


    /**
     * Creates a new Waiter
     *
     * @return a Waiter
     */
    public Person createPersonWaiter() {
        return new PersonWaiter("Waiter");
    }

    /**
     * Overridden toString method
     *
     * @return the name of the factory
     */
    @Override
    public String toString() {
        return "Person Factory";
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