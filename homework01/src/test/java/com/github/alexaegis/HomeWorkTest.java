package com.github.alexaegis;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HomeWorkTest {

	@Test
	public void incorrectSingleRightTest() throws EmptyStackException {
		assertFalse(new BracketChecker(new Stack(")")).isCorrect());
	}

	@Test
	public void incorrectSingleLeftTest() throws EmptyStackException {
		assertFalse(new BracketChecker(new Stack("(")).isCorrect());
	}

	@Test
	public void correctSingleTest() throws EmptyStackException {
		assertTrue(new BracketChecker(new Stack("()")).isCorrect());
	}

	@Test
	public void incorrectPlusLeftTest() throws EmptyStackException {
		assertFalse(new BracketChecker(new Stack("(()")).isCorrect());
	}

	@Test
	public void correctNestedTest() throws EmptyStackException {
		assertTrue(new BracketChecker(new Stack("(())")).isCorrect());
	}

	@Test
	public void incorrectNestedTest() throws EmptyStackException {
		assertFalse(new BracketChecker(new Stack("((())")).isCorrect());
	}

	@Test
	public void correctComplexSequenceTest() throws EmptyStackException {
		assertTrue(new BracketChecker(new Stack("(()()(()(()())()))")).isCorrect());
	}

	@Test
	public void incorrectComplexSequenceTest() throws EmptyStackException {
		assertFalse(new BracketChecker(new Stack("(()()(()(()())())))")).isCorrect());
	}

}