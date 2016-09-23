package com.github.alexaegis;

import com.github.alexaegis.shop.Product;
import com.github.alexaegis.shop.ProductFactory;

public class Main {

	public static void main(String[] args) {
		Product product = ProductFactory.getFactory().createBread();
	}

}