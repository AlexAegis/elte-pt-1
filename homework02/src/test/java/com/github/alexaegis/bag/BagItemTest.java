package com.github.alexaegis.bag;

import com.github.alexaegis.bag.BagItem;
import com.github.alexaegis.shop.Product;
import com.github.alexaegis.shop.ProductFactory;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BagItemTest {

	@Test
	public void sameProductEqualsTest() {
		BagItem bagItemA = new BagItem(ProductFactory.getFactory().createBread(), 3);
		BagItem bagItemB = new BagItem(ProductFactory.getFactory().createBread(), 0);
		assertTrue(bagItemA.equals(bagItemB));
	}

	@Test
	public void differentProductDiffersTest() {
		BagItem bagItemA = new BagItem(ProductFactory.getFactory().createBread(), 0);
		BagItem bagItemB = new BagItem(ProductFactory.getFactory().createMilk(), 0);
		assertFalse(bagItemA.equals(bagItemB));
	}
	
}