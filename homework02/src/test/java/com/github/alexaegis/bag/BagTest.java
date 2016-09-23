package com.github.alexaegis.bag;

import com.github.alexaegis.bag.Bag;
import com.github.alexaegis.exceptions.NoSuchElementException;
import com.github.alexaegis.shop.ProductFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagTest {

	@Test
	public void bagLengthTest() throws Exception {
		Bag bag = new Bag();
		bag.add(ProductFactory.getFactory().createBread());
		bag.add(ProductFactory.getFactory().createBread());
		assertEquals(2, bag.length());
	}

	@Test
	public void bagLengthAndRemoveTest() throws Exception {
		Bag bag = new Bag();
		bag.add(ProductFactory.getFactory().createBread());
		bag.remove(ProductFactory.getFactory().createBread());
		assertEquals(0, bag.length());
	}

	@Test
	public void bagLengthAndRemoveComplexTest() throws Exception {
		Bag bag = new Bag();
		bag.add(ProductFactory.getFactory().createBread())
				.add(ProductFactory.getFactory().createBread())
				.add(ProductFactory.getFactory().createMilk())
				.add(ProductFactory.getFactory().createBread())
				.add(ProductFactory.getFactory().createMilk());
		bag.remove(ProductFactory.getFactory().createBread())
				.remove(ProductFactory.getFactory().createMilk());
		assertEquals(3, bag.length());
	}

	@Test
	public void unionTest() throws Exception {
		Bag bag1 = new Bag().add(ProductFactory.getFactory().createBread())
				.add(ProductFactory.getFactory().createMilk());
		Bag bag2 = new Bag().add(ProductFactory.getFactory().createGeneric("gen2", 20))
				.add(ProductFactory.getFactory().createGeneric("gen", 10));
		Bag bag3 = Bag.union(bag1, bag2);
		assertEquals(4, bag3.length());
	}

	@Test
	public void unionComplexTest() throws Exception {
		Bag bag1 = new Bag().add(ProductFactory.getFactory().createBread())
				.add(ProductFactory.getFactory().createMilk())
				.add(ProductFactory.getFactory().createMilk());
		Bag bag2 = new Bag().add(ProductFactory.getFactory().createMilk())
				.add(ProductFactory.getFactory().createGeneric("gen", 10));
		Bag bag3 = Bag.union(bag1, bag2);
		assertEquals(5, bag3.length());
	}

	@Test(expected = NoSuchElementException.class)
	public void illegalRemoveTest() throws Exception {
		Bag bag = new Bag();
		bag.add(ProductFactory.getFactory().createMilk());
		bag.remove(ProductFactory.getFactory().createMilk())
				.remove(ProductFactory.getFactory().createMilk());
	}
}