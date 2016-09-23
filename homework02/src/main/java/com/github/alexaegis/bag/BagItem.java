package com.github.alexaegis.bag;

import com.github.alexaegis.shop.Product;

public class BagItem {

	private final Product product;
	private int multiplicity;

	BagItem(Product product, int multiplicity) {
		this.product = product;
		this.multiplicity = multiplicity;
	}

	public Product getProduct() {
		return product;
	}

	public int getMultiplicity() {
		return multiplicity;
	}

	public BagItem setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
		return this;
	}

	BagItem addOccurence(int occurences) {
		this.multiplicity += occurences;
		return this;
	}

	BagItem removeOccurence(int occurences) {
		if(occurences > this.multiplicity) {
			throw new IllegalArgumentException();
		}
		multiplicity -= occurences;
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

		BagItem bagItem = (BagItem) o;

		return this.product.equals(bagItem.product);

	}

	@Override
	public int hashCode() {
		return this.product.hashCode();
	}
}