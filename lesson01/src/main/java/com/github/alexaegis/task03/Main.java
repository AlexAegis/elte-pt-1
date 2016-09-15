package com.github.alexaegis.task03;


public class Main {

	private static Stack stack;

	private Main() {

	}

	public static void main(String[] args) {
		stack = new Stack().append(3);
		stack.append(2);
		System.out.println(stack.getListLength());

	}

}