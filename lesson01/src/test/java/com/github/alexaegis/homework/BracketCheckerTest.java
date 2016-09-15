package com.github.alexaegis.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketCheckerTest {

	private Logger logger = LoggerFactory.getLogger(BracketCheckerTest.class);
	private Stack stack;

	@Before
	public void before() {
		this.stack = new Stack();
	}

	@After
	public void after() {
		this.stack = null;
	}

	@Test
	public void correctSequenceTest() throws EmptyCharStackException {
		this.stack.append('(')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void incorrectPairTest() throws EmptyCharStackException {
		this.stack.append('(')
				.append(']');
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void multipleCorrectNonInterlacingBracketsTest() throws EmptyCharStackException {
		this.stack.append('(')
				.append(')')
				.append('(')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void correctComplexSequenceTest() throws EmptyCharStackException {
		this.stack.append('(')
				.append('(')
				.append(')')
				.append('[')
				.append(']')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void correctComplexSequence2Test() throws EmptyCharStackException {
		this.stack.append('(')
				.append('(')
				.append(')')
				.append('(')
				.append(')')
				.append('[')
				.append(']')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void incorrectComplexSequenceTest() throws EmptyCharStackException {
		this.stack.append('(')
				.append('(')
				.append(')')
				.append('[')
				.append('(')
				.append('}')
				.append(']')
				.append(')');
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

	@Test(expected = EmptyCharStackException.class)
	public void emptyStackTest() throws EmptyCharStackException {
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void incorrectSequenceTest() throws EmptyCharStackException {
		this.stack.append(')')
				.append('(');
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

}