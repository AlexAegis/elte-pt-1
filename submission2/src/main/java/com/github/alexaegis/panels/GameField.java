package com.github.alexaegis.panels;

import com.github.alexaegis.Main;
import com.github.alexaegis.buttons.Tile;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private static final int GRID_SIZE_DEFAULT = Integer.parseInt(Main.getProps().getProperty("grid_size_default"));
    private static final int GRID_GAP= Integer.parseInt(Main.getProps().getProperty("grid_gap"));
    private static final int TILE_SIZE = Integer.parseInt(Main.getProps().getProperty("tile_size"));

    public GameField() {
        GridBagLayout gridLayout = new GridBagLayout();

        setLayout(new GridLayout(20,40));
        for (int i = 0; i < GRID_SIZE_DEFAULT * GRID_SIZE_DEFAULT; i++) {
            add(new Tile());
        }
    }
}