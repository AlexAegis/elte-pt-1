package com.github.alexaegis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HomeWorkTest {

	private Logger logger = LoggerFactory.getLogger(BracketCheckerTest.class);

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@Test
	public void incorrectSingleRightTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(new Stack(")")).isCorrect());
	}

	@Test
	public void incorrectSingleLeftTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(new Stack("(")).isCorrect());
	}

	@Test
	public void correctSingleTest() throws EmptyCharStackException {
		assertTrue(new BracketChecker(new Stack("()")).isCorrect());
	}

	@Test
	public void incorrectPlusLeftTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(new Stack("(()")).isCorrect());
	}

	@Test
	public void correctNestedTest() throws EmptyCharStackException {
		assertTrue(new BracketChecker(new Stack("(())")).isCorrect());
	}

	@Test
	public void incorrectNestedTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(new Stack("((())")).isCorrect());
	}

	@Test
	public void correctComplexSequenceTest() throws EmptyCharStackException {
		assertTrue(new BracketChecker(new Stack("(()()(()(()())()))")).isCorrect());
	}

	@Test
	public void incorrectComplexSequenceTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(new Stack("(()()(()(()())())))")).isCorrect());
	}

}