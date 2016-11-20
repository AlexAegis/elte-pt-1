package com.github.alexaegis.elements;

import javax.swing.*;

public class NumberSelector extends JComboBox {

    private int value = 4;

    public NumberSelector() {
        setEnabled(false);
        for (int i = 3; i < 20; i++) {
            addItem(i + 1);
        }
        addActionListener(actionEvent -> value = Integer.parseInt(getSelectedItem().toString()));
    }

    public int getValue() {
        return value;
    }
}