package com.github.alexaegis.homework;

public class BracketChecker {

	private Stack stack;
	private Stack temp;

	private BracketChecker() {

	}

	public BracketChecker(Stack stack) throws EmptyCharStackException {
		if (stack.isEmpty()) {
			throw new EmptyCharStackException();
		} else {
			this.stack = stack;
			this.temp = new Stack();
		}
	}

	public boolean isCorrect() {

		int len = stack.length();

		for (int i = 0; i < len; i++) {

			char current = stack.getAndRemoveLast();

			if (Brackets.isClosing(current)) {
				temp.append(current);
			} else if (Brackets.isOpening(current)	) {

				if (temp.isEmpty()) {
					return false;
				}

				char last = temp.getAndRemoveLast();

				if(Brackets.NORMAL.isBracket(last) && !Brackets.NORMAL.matcher(current, last) ) {
					return false;
				} else if(Brackets.CURLY.isBracket(last) && !Brackets.CURLY.matcher(current, last)) {
					return false;
				} else if(Brackets.SQUARE.isBracket(last) && !Brackets.SQUARE.matcher(current, last)) {
					return false;
				} else {
					temp.append(last); //Go back where you belong!
				}
			}
		}
		return this.stack.isEmpty();
	}
}