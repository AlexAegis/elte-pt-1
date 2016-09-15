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
	public void correctSequenceTest() {
		this.stack.append('(')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void incorrectPairTest() {
		this.stack.append('(')
				.append(']');
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void multipleCorrectNonInterlacingBracketsTest() {
		this.stack.append('(')
				.append(')')
				.append('(')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void correctComplexSequenceTest() {
		this.stack.append('(')
				.append('(')
				.append(')')
				.append('[')
				.append(']')
				.append(')');
		assertTrue(new BracketChecker(this.stack).isCorrect());
	}

	@Test
	public void incorrectComplexSequenceTest() {
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

	@Test
	public void incorrectSequenceTest() {
		this.stack.append(')')
				.append('(');
		assertFalse(new BracketChecker(this.stack).isCorrect());
	}

}