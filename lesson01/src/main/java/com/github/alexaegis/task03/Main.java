package com.github.alexaegis.task03;


public class Main {

	private Main() {

	}

	public static void main(String[] args) {
		Stack stack = new Stack().append(7);
		stack.append(5);
		System.out.println("{7,5} original length: " + stack.getListLength());
		System.out.println("Last element in the list: " + stack.getAndRemoveLast() + ", removed.");
		System.out.println("New lenght of List: " + stack.getListLength());
		System.out.println("Is empty? " + stack.isEmpty());
		System.out.println("Last element in the list: " + stack.getAndRemoveLast() + ", removed.");
		System.out.println("Is empty? " + stack.isEmpty());

	}

}