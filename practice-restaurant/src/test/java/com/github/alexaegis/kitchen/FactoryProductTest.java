package com.github.alexaegis.kitchen;

import com.github.alexaegis.restaurant.kitchen.FactoryProduct;
import com.github.alexaegis.restaurant.kitchen.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FactoryProductTest {

    private Logger logger = LoggerFactory.getLogger(FactoryProductTest.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void factoryExistenceTest() {
        assertNotNull("Factory's singleton pattern not working", FactoryProduct.getFactory());
        logger.info("Product factory working");
    }

    @Test
    public void productDrinkWater() {
        Product testWater = FactoryProduct.getFactory().createDrinkWater();
        assertNotNull("TestWater got no name", testWater.getName());
        assertNotNull("TestWater got no value", testWater.getValue());
        assertNotNull("TestWater got no quality", testWater.getQuality());
        logger.info("Water variables initialized");
    }

    @Test
    public void productFoodAppetizer() {
        Product testAppetizer = FactoryProduct.getFactory().createFoodAppetizer();
        assertNotNull("TestAppetizer got no name", testAppetizer.getName());
        assertNotNull("TestAppetizer got no value", testAppetizer.getValue());
        assertNotNull("TestAppetizer got no quality", testAppetizer.getQuality());
        logger.info("Appetizer variables initialized");
    }

    @Test
    public void productFoodMain() {
        Product testMain = FactoryProduct.getFactory().createFoodMain();
        assertNotNull("TestMain got no name", testMain.getName());
        assertNotNull("TestMain got no value", testMain.getValue());
        assertNotNull("TestMain got no quality", testMain.getQuality());
        logger.info("Main variables initialized");
    }

    @Test
    public void productFoodDessert() {
        Product testDessert = FactoryProduct.getFactory().createFoodDessert();
        assertNotNull("TestDessert got no name", testDessert.getName());
        assertNotNull("TestDessert got no value", testDessert.getValue());
        assertNotNull("TestDessert got no quality", testDessert.getQuality());
        logger.info("Dessert variables initialized");
    }
}