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

	public int getAndRemoveLast() {
		int result = this.myList.get(this.getListLength() - 1);
		this.myList.remove(this.getListLength() - 1);
		return result;
	}

	public boolean isEmpty() {
		return this.myList.isEmpty();
	}

}