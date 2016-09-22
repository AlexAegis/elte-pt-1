package com.github.alexaegis.task01;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bag {

	private Set<BagItem> container = new HashSet<>();

	public Bag add(int value) {
		add(value, 1);
		return this;
	}

	public Bag add(int value, int multiplicity) {
		if(contains(value)) {
			BagItem bagItem = getBagItem(value);
			bagItem.addOccurence(multiplicity);
		} else {
			this.container.add(new BagItem(value, multiplicity));
		}
		return this;
	}

	private BagItem getBagItem(int value) {
		Optional<BagItem> o = getWithValue(value);
		return o.get();
	}

	private boolean contains(int value) {
		Optional<BagItem> o = getWithValue(value);
		return o.isPresent();
	}

	private Optional<BagItem> getWithValue(int value) {
		return container.stream().filter(bi -> {
			return bi.getValue() == value;
		}).findFirst();
	}
}