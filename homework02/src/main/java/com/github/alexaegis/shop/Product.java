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
}