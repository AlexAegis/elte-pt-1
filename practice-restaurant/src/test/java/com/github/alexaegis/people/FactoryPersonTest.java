package com.github.alexaegis.people;

import com.github.alexaegis.restaurant.kitchen.FactoryProduct;
import com.github.alexaegis.restaurant.kitchen.Product;
import com.github.alexaegis.restaurant.people.FactoryPerson;
import com.github.alexaegis.restaurant.people.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FactoryPersonTest {

    private Logger logger = LoggerFactory.getLogger(FactoryPersonTest.class);

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void factoryExistenceTest() {
        assertNotNull("Factory's singleton pattern not working", FactoryPerson.getFactory());
        logger.info("Person factory working");
    }

    @Test
    public void productPersonGuest() {
        Person testGuest = FactoryPerson.getFactory().createPersonGuest();
        assertNotNull("TestWater got no name", testGuest.getName());
        logger.info("Guest variables initialized");
    }

    @Test
    public void productPersonChef() {
        Person testChef = FactoryPerson.getFactory().createPersonChef();
        assertNotNull("TestChef got no name", testChef.getName());
        logger.info("Chef variables initialized");
    }

    @Test
    public void productPersonWaiter() {
        Person testWaiter = FactoryPerson.getFactory().createPersonWaiter();
        assertNotNull("TestWaiter got no name", testWaiter.getName());
        logger.info("Waiter variables initialized");
    }
}