package com.github.alexaegis;

import com.github.alexaegis.bag.BagItem;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BagItemTest {

	@Test
	public void sameValueEqualsTest() {
		BagItem bagItemA = new BagItem(1, 0);
		BagItem bagItemB = new BagItem(1, 0);
		assertTrue(bagItemA.equals(bagItemB));
	}

	@Test
	public void differentValueDiffersTest() {
		BagItem bagItemA = new BagItem(1, 0);
		BagItem bagItemB = new BagItem(2, 0);
		assertFalse(bagItemA.equals(bagItemB));
	}

}