package com.github.alexaegis.elements;

public class ExitButton extends GameButton {

    public ExitButton() {
        name = "Exit";
        setName(name);
        setText(name);
        addActionListener(actionEvent -> System.exit(0));
    }
}