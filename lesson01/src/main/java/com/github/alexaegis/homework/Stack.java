package com.github.alexaegis.homework;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Character> myList;

	public Stack() {
		this.myList = new ArrayList<>();
	}

	public int length() {
		return myList.size();
	}

	public Stack append(char n) {
		this.myList.add(n);
		return this;
	}

	public char getAndRemoveLast() {
		char result = this.myList.get(this.length() - 1);
		this.myList.remove(this.length() - 1);
		return result;
	}

	public boolean isEmpty() {
		return this.myList.isEmpty();
	}

}