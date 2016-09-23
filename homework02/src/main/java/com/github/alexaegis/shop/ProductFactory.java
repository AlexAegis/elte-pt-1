package com.github.alexaegis.shop;

public class ProductFactory {

	private static ProductFactory instance;

	private ProductFactory() {

	}

	public static ProductFactory getFactory() {

		if (instance == null) {

			synchronized(ProductFactory.class) {

				if (instance == null) {
					instance = new ProductFactory();
				}
			}
		}
		return instance;
	}

	public Product createBread() {
		return new Bread();
	}

	public Product createMilk() {
		return new Milk();
	}

	public Product createGeneric(String name, int price) {
		return new GenericProduct(name, price);
	}

}