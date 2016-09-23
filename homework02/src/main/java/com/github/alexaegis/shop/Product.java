package com.github.alexaegis.shop;

public abstract class Product {

	protected String name;
	protected int price;

	protected Product() {

	}

	public String getName() {
		return name;
	}

	protected Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getPrice() {
		return price;
	}

	protected Product setPrice(int price) {
		this.price = price;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Product product = (Product) o;

		if (price != product.price) {
			return false;
		}

		return name != null ? name.equals(product.name) : product.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + price;
		return result;
	}
}