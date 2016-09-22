package com.github.alexaegis.task01;

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

	public void setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
	}

	public BagItem addOccurence(int occurences) {
		this.multiplicity += occurences;
		return this;
	}

	public void removeOccurence(int occurences) throws IllegalArgumentException {
		if(occurences > this.multiplicity) {
			throw new IllegalArgumentException();
		}
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