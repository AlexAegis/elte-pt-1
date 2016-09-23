package com.github.alexaegis.bag;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bag<E> {

	private Set<E> container = new HashSet<>();

	public Bag add(int value) {
		add(value, 1);
		return this;
	}

	private Bag add(int value, int multiplicity) {
		if(contains(value)) {
			E item = getItem(value);
			item.addOccurence(multiplicity);
		} else {
			this.container.add(new E(value, multiplicity)); // TODO
		}
		return this;
	}

	private E getItem(int value) {
		Optional<E> o = getWithValue(value);
		return o.isPresent() ? o.get() : null ;
	}

	public Bag remove(int value) {
		remove(value, 1);
		return this;
	}

	private Bag remove(int value, int i) {
		if(getItem(value).getMultiplicity() == 1) {
			this.container.remove(getItem(value));
		} else {
			getItem(value).removeOccurence(i);
		}
		return this;
	}

	private boolean contains(int value) {
		Optional<E> o = getWithValue(value);
		return o.isPresent();
	}

	private Optional<E> getWithValue(int value) {
		return container.stream().filter(bi -> {
			return bi.getValue() == value;
		}).findFirst();
	}

	public static Bag union(Bag a, Bag b) {
		Bag result = new Bag<>();
		copyItems(a,result);
		copyItems(b,result);
		return result;
	}

	private static void copyItems(Bag source, Bag target) {
		source.container.stream().forEach(item -> {
			target.add(item.getValue(), item.getMultiplicity());
		});
	}

	public int length() {
		return this.container.size();
	}

}