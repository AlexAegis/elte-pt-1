package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.logic.GameModes;

import javax.swing.*;
import java.util.Arrays;

public class GameFieldSelector extends JComboBox {

    public GameFieldSelector() {
        Arrays.stream(FieldSizeOptions.values()).forEach(this::addItem);
        setSelectedIndex(0);
    }
}