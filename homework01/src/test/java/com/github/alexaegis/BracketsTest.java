package com.github.alexaegis;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketsTest {

	private Logger logger = LoggerFactory.getLogger(BracketsTest.class);

	@Before
	public void before() {
	}

	@Test
	public void bracketTest() {

		assertEquals("The curly opening bracket is not correct",
				'{', Brackets.CURLY.getOpening());
		assertEquals("The curly closing bracket is not correct",
				'}', Brackets.CURLY.getClosing());
		assertEquals("The normal opening bracket is not correct",
				'(', Brackets.NORMAL.getOpening());
		assertEquals("The normal closing bracket is not correct",
				')', Brackets.NORMAL.getClosing());
		assertEquals("The square opening bracket is not correct",
				'[', Brackets.SQUARE.getOpening());
		assertEquals("The square closing bracket is not correct",
				']', Brackets.SQUARE.getClosing());

		logger.info("All type of brackets added correctly");
	}

	@Test
	public void matcherTest() {

		assertTrue("The curly bracket matcher is not working if the sequence of the brackets is correct",
				Brackets.CURLY.matcher('{', '}'));
		assertTrue("The normal bracket matcher is not working if the sequence of the brackets is correct",
				Brackets.NORMAL.matcher('(', ')'));
		assertTrue("The square bracket matcher is not working if the sequence of the brackets is correct",
				Brackets.SQUARE.matcher('[', ']'));
	}

	@Test
	public void matcherReversedTest() {
		assertFalse("The curly bracket matcher is working if the sequence of the brackets is correct",
				Brackets.CURLY.matcher('}', '{'));
		assertFalse("The normal bracket matcher is working if the sequence of the brackets is correct",
				Brackets.NORMAL.matcher(')', '('));
		assertFalse("The square bracket matcher is working if the sequence of the brackets is correct",
				Brackets.SQUARE.matcher(']', '['));
	}
}
