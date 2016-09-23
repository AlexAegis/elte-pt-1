package com.github.alexaegis;

public class Main {

	public static void main(String[] args) throws EmptyStackException {
               new BracketChecker(new Stack("()")).isCorrect();
	}
}