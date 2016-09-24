package com.github.alexaegis.bag;

import com.github.alexaegis.exceptions.NoSuchElementException;
import com.github.alexaegis.shop.Product;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bag {

	private Set<BagItem> container = new HashSet<>();

	public Bag add(Product product) {
		return add(product, 1);
	}

	public Bag add(Product product, int multiplicity) {
		if(contains(product)) {
			BagItem bagItem;
			try {
				bagItem = getBagItem(product);
				bagItem.addOccurence(multiplicity);
			} catch (NoSuchElementException e)  {
				e.printStackTrace();
			}
		} else {
			this.container.add(new BagItem(product, multiplicity));
		}
		return this;
	}

	public Set<BagItem> getContainer() {
		return this.container;
	}

	private BagItem getBagItem(Product product) throws NoSuchElementException {
		Optional<BagItem> o = getWithProduct(product);
		if(o.isPresent()) {
			return o.get();
		} else {
			throw new NoSuchElementException();
		}
	}

	public Bag remove(Product product) throws NoSuchElementException {
		return remove(product, 1);
	}

	public Bag remove(Product product, int i) throws NoSuchElementException {
		if(getBagItem(product).getMultiplicity() == 1) {
			this.container.remove(getBagItem(product));
		} else {
			getBagItem(product).removeOccurence(i);
		}
		return this;
	}

	private boolean contains(Product product) {
		Optional<BagItem> o = getWithProduct(product);
		return o.isPresent();
	}

	private Optional<BagItem> getWithProduct(Product product) {
		return container.stream().filter(bi -> bi.getProduct().equals(product)).findFirst();
	}

	public static Bag union(Bag a, Bag b) {
		Bag result = new Bag();
		copyBagItems(a,result);
		copyBagItems(b,result);
		return result;
	}

	private static void copyBagItems(Bag source, Bag target) {
		source.container.forEach(bagItem ->
				target.add(bagItem.getProduct(), bagItem.getMultiplicity()));
	}

	public int uniqueLength() {
		return this.container.size();
	}

	public int length() {
		int result = 0;
		for (BagItem b : this.container) {
			result += b.getMultiplicity();
		}
		return result;
	}

}