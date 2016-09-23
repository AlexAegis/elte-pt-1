package com.github.alexaegis.shop;

public class CartFactory {

	private static CartFactory instance;

	private CartFactory() {

	}

	public static CartFactory getFactory() {

		if (instance == null) {

			synchronized(CartFactory.class) {

				if (instance == null) {
					instance = new CartFactory();
				}
			}
		}
		return instance;
	}

	public Cart createCart() {
		return new Cart();
	}
}