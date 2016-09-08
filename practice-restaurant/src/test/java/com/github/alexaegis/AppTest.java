package com.github.alexaegis;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class AppTest {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Before
    public void before() {
        logger.info("jUnit before working");
    }

    @Test
    public void jUnitTest() {
        assertTrue("jUnit assertion failed", true);
        logger.info("jUnit working");
    }

}