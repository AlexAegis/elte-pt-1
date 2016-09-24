package com.github.alexaegis.shop;

import com.github.alexaegis.bag.Bag;
import com.github.alexaegis.bag.BagItem;
import com.github.alexaegis.exceptions.NoSuchElementException;

public class Cart {

	private Bag bag;

	Cart() {
		this.bag = new Bag();
	}

	public Cart add(Product product) {
		this.bag.add(product);
		return this;
	}

	public Cart add(Product product, int n) {
		this.bag.add(product, n);
		return this;
	}

	public Cart remove(Product product) {
		try {
			this.bag.remove(product);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return this;
	}

	public Cart remove(Product product, int n) {
		try {
			this.bag.remove(product, n);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return this;
	}

	public int value() {
		int result = 0;
		for (BagItem bagItem : this.bag.getContainer()) {
			result += bagItem.getProduct().getPrice() * bagItem.getMultiplicity();
		}
		return result;
	}


}