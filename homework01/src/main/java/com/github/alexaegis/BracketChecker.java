package com.github.alexaegis;

public class BracketChecker {

	private Stack stack;
	private Stack temp;

	private BracketChecker() {

	}

	public BracketChecker(Stack stack) throws EmptyStackException {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			this.stack = stack;
			this.temp = new Stack();
		}
	}

	public boolean isCorrect() {

		int len = this.stack.length();

		for (int i = 0; i < len; i++) {

			char current = this.stack.getAndRemoveLast();

			if (Brackets.isClosing(current)) {
				this.temp.append(current);
			} else if (Brackets.isOpening(current)	) {

				if (this.temp.isEmpty()) {
					return false;
				}

				char last = this.temp.getAndRemoveLast();

				if(Brackets.NORMAL.isBracket(last) && Brackets.NORMAL.isBracket(current) && !(Brackets.NORMAL.isClosing(last) && Brackets.NORMAL.isOpening(current))) {
					this.temp.append(last);
				} else if(Brackets.CURLY.isBracket(last) && Brackets.CURLY.isBracket(current) && !(Brackets.CURLY.isClosing(last) && Brackets.CURLY.isOpening(current))) {
					this.temp.append(last);
				} else if(Brackets.SQUARE.isBracket(last) && Brackets.SQUARE.isBracket(current) && !(Brackets.SQUARE.isClosing(last) && Brackets.SQUARE.isOpening(current))) {
					this.temp.append(last);
				}

			}
		}
		return this.stack.isEmpty() && this.temp.isEmpty();
	}
}