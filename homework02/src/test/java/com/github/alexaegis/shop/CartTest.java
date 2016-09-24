package com.github.alexaegis.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartTest {

	private Cart cart;
	private Product bread;
	private Product milk;

	@Before
	public void initializeCart() {
		this.cart = CartFactory.getFactory().createCart();
		this.bread = ProductFactory.getFactory().createBread();
		this.milk = ProductFactory.getFactory().createMilk();
	}

	@After
	public void destruct() {
		this.cart = null;
		this.bread = null;
		this.milk = null;
	}

	@Test
	public void emptyCartValueTest() throws Exception {
		assertEquals(0, cart.value());
	}

	@Test
	public void cartValueDifferentItemsTest() throws Exception {
		cart.add(bread).add(milk);
		assertEquals(bread.getPrice() + milk.getPrice(), cart.value());
	}

	@Test
	public void cartValueSameItemsTest() throws Exception {
		cart.add(bread).add(bread);
		assertEquals(bread.getPrice() * 2, cart.value());
	}

	@Test
	public void multiItemAddTest() throws Exception {
		cart.add(bread, 2);
		assertEquals(bread.getPrice() * 2, cart.value());
	}

	@Test
	public void multiItemRemoveTest() throws Exception {
		cart.add(bread, 2);
		cart.remove(bread, 2);
		assertEquals(0, cart.value());
	}
}