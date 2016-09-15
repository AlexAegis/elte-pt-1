package com.github.alexaegis.homework;

public enum Brackets {

	CURLY ('{', '}'),
	NORMAL('(', ')'),
	SQUARE('[', ']');

	private char opening;
	private char closing;

	Brackets(char opening, char closing) {
		this.setOpening(opening);
		this.setClosing(closing);
	}

	public char getOpening() {
		return opening;
	}

	private void setOpening(char opening) {
		this.opening = opening;
	}

	public char getClosing() {
		return closing;
	}

	private void setClosing(char closing) {
		this.closing = closing;
	}

	public boolean matcher(char a, char b) {
		return a == this.getOpening() && b == this.getClosing();
	}

	public boolean isBracket(char a) {
		return a == this.getOpening() || a == this.getClosing();
	}
}
