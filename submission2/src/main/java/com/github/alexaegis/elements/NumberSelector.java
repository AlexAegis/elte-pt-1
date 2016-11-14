package com.github.alexaegis.elements;

import javax.swing.*;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public class NumberSelector extends JComboBox {

    private int value = 1;

    public NumberSelector() {
        setEnabled(false);
        for (int i = 0; i < 20; i++) {
            addItem(i + 1);
        }
        addActionListener(actionEvent -> value = Integer.parseInt(getSelectedItem().toString()));
    }

    public int getValue() {
        return value;
    }
}