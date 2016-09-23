package com.github.alexaegis;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class BagTest {

	@Test
	public void bagLengthTest() {
		Bag bag = new Bag();
		bag.add(1);
		bag.add(3);
		assertEquals(2, bag.length());
	}

	@Test
	public void bagLengthAndRemoveTest() {
		Bag bag = new Bag();
		bag.add(1);
		bag.remove(1);
		assertEquals(0, bag.length());
	}

	@Test
	public void bagLengthAndRemoveComplexTest() {
		Bag bag = new Bag();
		bag.add(1).add(2).add(2).add(4).add(5);
		bag.remove(1).remove(2);
		assertEquals(3, bag.length());
	}

	@Test
	public void unionTest() {
		Bag bag1 = new Bag().add(1).add(2);
		Bag bag2 = new Bag().add(3).add(4);
		Bag bag3 = Bag.union(bag1, bag2);
		assertEquals(4, bag3.length());
	}

	@Test
	public void unionComplexTest() {
		Bag bag1 = new Bag().add(1).add(2).add(3);
		Bag bag2 = new Bag().add(3).add(4);
		Bag bag3 = Bag.union(bag1, bag2);
		assertEquals(4, bag3.length());
	}

	@Test(expected = NoSuchElementException.class)
	public void illegalRemoveTest() throws NoSuchElementException {
		Bag bag = new Bag();
		bag.add(1);
		bag.remove(1).remove(1);
	}
}