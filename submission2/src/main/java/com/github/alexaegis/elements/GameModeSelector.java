package com.github.alexaegis.elements;

import com.github.alexaegis.logic.GameModes;

import javax.swing.*;

public class GameModeSelector extends JComboBox {

    public GameModeSelector() {
        addItem(GameModes.DASH);
        addItem(GameModes.DASH_WITH_REAL_PAWNS);
        setSelectedIndex(0);
    }
}