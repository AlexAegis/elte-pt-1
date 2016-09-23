package com.github.alexaegis;

public class BagItem {

	private final int value;
	private int multiplicity;

	public BagItem(int value, int multiplicity) {
		this.value = value;
		this.multiplicity = multiplicity;
	}

	public int getValue() {
		return value;
	}

	public int getMultiplicity() {
		return multiplicity;
	}

	public BagItem setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
		return this;
	}

	public BagItem addOccurence(int occurences) {
		this.multiplicity += occurences;
		return this;
	}

	public BagItem removeOccurence(int occurences) throws IllegalArgumentException {
		if(occurences > this.multiplicity) {
			throw new IllegalArgumentException();
		}
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

		return this.value == bagItem.value;

	}

	@Override
	public int hashCode() {
		return this.value;
	}
}