package com.github.alexaegis.shop;

public abstract class Product {

	private String name;
	private int price;

	Product() {

	}

	public String getName() {
		return this.name;
	}

	Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getPrice() {
		return this.price;
	}

	Product setPrice(int price) {
		this.price = price;
		return this;
	}

	@Override
	public String toString() {
		return "Product{" +
				"name='" + this.name + '\'' +
				", price=" + this.price +
				'}';
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

		return this.price == product.price && (this.name != null
				? this.name.equals(product.name)
				: product.name == null);
	}

	@Override
	public int hashCode() {
		int result = this.name != null ? this.name.hashCode() : 0;
		result = 31 * result + this.price;
		return result;
	}
}