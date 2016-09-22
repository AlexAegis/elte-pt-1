package com.github.alexaegis;

public class Main {

	public static void main(String[] args) throws EmptyCharStackException {
		Stack stack = new Stack();
		stack.append('(').append(')');
		System.out.println(stack.length());
		System.out.println(new BracketChecker(stack).isCorrect());

		Stack stack2 = new Stack();
		stack2.append('(').append(']');
		System.out.println(stack2.length());
		System.out.println(new BracketChecker(stack2).isCorrect());

		Stack stack3 = new Stack();
		stack2.append('(').append('[').append(')').append(']');
		System.out.println(stack2.length());
		System.out.println(new BracketChecker(stack2).isCorrect());

		Stack stack4 = new Stack();
		stack2.append('(').append(')').append('{').append('}');
		System.out.println(stack2.length());
		System.out.println(new BracketChecker(stack2).isCorrect());
	}
}