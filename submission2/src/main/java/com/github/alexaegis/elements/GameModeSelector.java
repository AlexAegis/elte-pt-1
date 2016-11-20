package com.github.alexaegis.elements;

import com.github.alexaegis.logic.GameModes;

import javax.swing.*;
import java.util.Arrays;

public class GameModeSelector extends JComboBox {
    public GameModeSelector() {
        Arrays.stream(GameModes.values()).forEach(this::addItem);
        setSelectedIndex(0);
    }
}