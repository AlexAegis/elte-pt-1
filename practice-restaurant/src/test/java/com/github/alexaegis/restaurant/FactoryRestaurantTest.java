package com.github.alexaegis.restaurant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class FactoryRestaurantTest {

    private Logger logger = LoggerFactory.getLogger(FactoryRestaurantTest.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void factoryExistenceTest() {
        assertNotNull("Factory's singleton pattern not working", FactoryRestaurant.getFactory());
        logger.info("Restaurant factory working");
    }

    @Test
    public void restaurantAlpha() {
        Restaurant testRestaurant = FactoryRestaurant.getFactory().createRestaurantAlpha();
        assertNotNull("TestRestaurant got no name", testRestaurant.getName());
        logger.info("Restaurant Alpha variables initialized");
    }
}