package com.github.alexaegis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import static org.junit.Assert.assertTrue;

public class AppTest {

	private Logger logger = LoggerFactory.getLogger(AppTest.class);

	@Before
	public void before() {

	}

	@After
	public void after() {
	}

	@Test
	public void jUnitTest() {
		assertTrue("jUnit assertion failed", true);
		logger.info("jUnit working");
	}
}