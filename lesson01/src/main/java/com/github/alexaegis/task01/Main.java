package com.github.alexaegis.task01;

public class Main {

	private Main() {

	}

	public static void main(String[] args) {
		f(1,2,3,4);
	}

	private static void f(int... numbers) {
		for (int n : numbers) {
			System.out.println(n);
		}
	}
}