package com.github.alexaegis;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple Main.
 */
public class MainTest {

    private Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Before
    public void before() {

    }

    @Test
    public void jUnitTest() {
        assertTrue("jUnit assertion failed", true);
        new ArrayList<>();
    }

}