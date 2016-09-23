package com.github.alexaegis.shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartTest {

	@Test
	public void emptyCartValueTest() throws Exception {
		Cart cart = CartFactory.getFactory().createCart();
		assertEquals(0, cart.value());
	}

	@Test
	public void cartValueDifferentItemsTest() throws Exception {
		Cart cart = CartFactory.getFactory().createCart();
		cart.add(ProductFactory.getFactory().createBread());
		cart.add(ProductFactory.getFactory().createMilk());
		assertEquals(ProductFactory.getFactory().createBread().getPrice()
						+ ProductFactory.getFactory().createMilk().getPrice()
				, cart.value());
	}

	@Test
	public void cartValueSameItemsTest() throws Exception {
		Cart cart = CartFactory.getFactory().createCart();
		cart.add(ProductFactory.getFactory().createBread());
		cart.add(ProductFactory.getFactory().createBread());
		assertEquals(ProductFactory.getFactory().createBread().getPrice() * 2
				, cart.value());
	}
}
