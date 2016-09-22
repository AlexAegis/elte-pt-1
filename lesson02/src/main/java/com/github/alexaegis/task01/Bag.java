package com.github.alexaegis.task01;

import java.util.HashSet;
import java.util.Set;

public class Bag {

	private Set<BagItem> container = new HashSet<>();

	public Bag(Set<BagItem> container) {
		this.container = container;
	}
}