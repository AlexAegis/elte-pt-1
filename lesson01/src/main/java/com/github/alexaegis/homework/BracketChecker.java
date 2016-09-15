package com.github.alexaegis.homework;

public class BracketChecker {

	Stack stack;
	Stack temp;

	private BracketChecker() {

	}

	public BracketChecker(Stack stack) {
		this.stack = stack;
		this.temp = new Stack();
	}

	public boolean isCorrect() {

		if (stack.isEmpty()) {
			return true;
		}

		int l = stack.length();

		for (int i = 0; i < l; i++) {

			char current = stack.getAndRemoveLast();

			if (current == Brackets.CURLY.getClosing() 		||
					current == Brackets.NORMAL.getClosing() ||
					current == Brackets.SQUARE.getClosing()	) {

				temp.append(current);
			}

			if (current == Brackets.CURLY.getOpening() 		||
					current == Brackets.NORMAL.getOpening() ||
					current == Brackets.SQUARE.getOpening()	) {

				if (temp.isEmpty()) {
					return false;
				}

				char last = temp.getAndRemoveLast();

				if(Brackets.NORMAL.isBracket(last)  && !Brackets.NORMAL.matcher(current, last) ) {
					return false;
				} else if(Brackets.CURLY.isBracket(last)  && !Brackets.CURLY.matcher(current, last)) {
					return false;
				} else if(Brackets.SQUARE.isBracket(last)  && !Brackets.SQUARE.matcher(current, last)) {
					return false;
				} else {
					temp.append(last);
				}

			}
		}
		return this.stack.isEmpty();
	}
}