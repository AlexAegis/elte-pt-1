package com.github.alexaegis.shop;

public abstract class Product {

	private String name;
	private int price;

	Product() {

	}

	public String getName() {
		return name;
	}

	Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getPrice() {
		return price;
	}

	Product setPrice(int price) {
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

		return price == product.price && (name != null
				? name.equals(product.name)
				: product.name == null);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + price;
		return result;
	}
}