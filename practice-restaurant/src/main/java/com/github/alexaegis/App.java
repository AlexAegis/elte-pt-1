package com.github.alexaegis;

import com.github.alexaegis.restaurant.FactoryRestaurant;
import com.github.alexaegis.restaurant.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static Restaurant restaurantAlpha = FactoryRestaurant.getFactory().createRestaurantAlpha();

    private App() {

    }

    public static void main(String[] args) {
        logger.info(restaurantAlpha.getName());
    }
}