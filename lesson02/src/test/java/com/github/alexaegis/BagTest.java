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

	@Test(expected = NoSuchElementException.class)
	public void illegalRemoveTest() throws NoSuchElementException {
		Bag bag = new Bag();
		bag.add(1);
		bag.remove(1).remove(1);
	}
}