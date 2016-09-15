package com.github.alexaegis;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple Main.
 */
public class AppTest {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Before
    public void before() {
        logger.info("jUnit before working");
    }

    @org.junit.Test
    public void jUnitTest() {
        assertTrue("jUnit assertion failed", true);
        logger.info("jUnit working");
    }

}