package com.github.alexaegis.task03;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Integer> myList;

	public Stack() {
		this.myList = new ArrayList<>();
	}

	public int getListLength() {
		return myList.size();
	}

	public Stack append(int n) {
		this.myList.add(n);
		return this;
	}

}