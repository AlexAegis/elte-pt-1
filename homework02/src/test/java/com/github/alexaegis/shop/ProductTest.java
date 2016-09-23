package com.github.alexaegis.shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductTest {

	@Test
	public void breadTest() throws Exception {
		Product bread = ProductFactory.getFactory().createBread();
	}

	@Test
	public void sameProductTest() throws Exception {
		assertEquals(ProductFactory.getFactory().createBread(), ProductFactory.getFactory().createBread());

	}

	@Test
	public void differentProductTest() throws Exception {
		assertNotEquals(ProductFactory.getFactory().createBread(), ProductFactory.getFactory().createMilk());

	}
}