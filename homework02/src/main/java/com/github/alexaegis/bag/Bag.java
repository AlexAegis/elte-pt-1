package com.github.alexaegis.bag;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bag {

	private Set<BagItem> container = new HashSet<>();

	public Bag add(int value) {
		add(value, 1);
		return this;
	}

	private Bag add(int value, int multiplicity) {
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

	public Bag remove(int value) {
		remove(value, 1);
		return this;
	}

	private Bag remove(int value, int i) {
		if(getBagItem(value).getMultiplicity() == 1) {
			this.container.remove(getBagItem(value));
		} else {
			getBagItem(value).removeOccurence(i);
		}
		return this;
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

	public static Bag union(Bag a, Bag b) {
		Bag result = new Bag();
		copyBagItems(a,result);
		copyBagItems(b,result);
		return result;
	}

	private static void copyBagItems(Bag source, Bag target) {
		source.container.stream().forEach(bagItem -> {
			target.add(bagItem.getValue(), bagItem.getMultiplicity());
		});
	}

	public int length() {
		return this.container.size();
	}

}