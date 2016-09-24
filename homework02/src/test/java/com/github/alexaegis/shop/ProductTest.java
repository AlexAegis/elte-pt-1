package com.github.alexaegis.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductTest {

	private Product bread;

	@Before
	public void breadTest() throws Exception {
		 this.bread = ProductFactory.getFactory().createBread();
	}

	@Test
	public void sameProductTest() throws Exception {
		assertEquals(bread, ProductFactory.getFactory().createBread());
	}

	@Test
	public void differentProductTest() throws Exception {
		assertNotEquals(bread, ProductFactory.getFactory().createMilk());
	}

}