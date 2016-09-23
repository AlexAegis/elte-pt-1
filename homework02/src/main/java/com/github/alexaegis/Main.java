package com.github.alexaegis;

import com.github.alexaegis.shop.Cart;
import com.github.alexaegis.shop.CartFactory;
import com.github.alexaegis.shop.Product;
import com.github.alexaegis.shop.ProductFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	private Main() {

	}

	public static void main(String[] args) {

		Product bread = ProductFactory.getFactory().createBread();
		Product milk = ProductFactory.getFactory().createMilk();

		Cart cart = CartFactory.getFactory().createCart();

		cart.add(bread).add(milk);

		logger.info("The carts total value: " + cart.value());

	}
}