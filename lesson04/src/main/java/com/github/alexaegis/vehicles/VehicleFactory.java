package com.github.alexaegis.vehicles;

public class VehicleFactory {

    private static VehicleFactory instance;

    private VehicleFactory() {

    }

    public static VehicleFactory getFactory() {

        if (instance == null) {

            synchronized(VehicleFactory.class) {

                if (instance == null) {
                    instance = new VehicleFactory();
                }
            }
        }
        return instance;
    }

    public Car createCar() {
        return new Car();
    }

    public Bus createBus() {
        return new Bus();
    }

    public Truck createTruck() {
        return new Truck();
    }

}