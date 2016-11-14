package com.github.alexaegis.panels;

import com.github.alexaegis.tiles.BackGroundTile;
import com.github.alexaegis.tiles.Tile;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.GRID_DIMENSIONS;
import static com.github.alexaegis.Main.GRID_TILECOUNT_DEFAULT;

public class GameField extends JPanel {

    public GameField() {

        setLayout(new GridLayout(GRID_TILECOUNT_DEFAULT, GRID_TILECOUNT_DEFAULT));
        setPreferredSize(GRID_DIMENSIONS);
        setBounds(0, 0, GRID_DIMENSIONS.width, GRID_DIMENSIONS.height);
        for (int i = 0; i < GRID_TILECOUNT_DEFAULT; i++) {
            for (int j = 0; j < GRID_TILECOUNT_DEFAULT; j++) {
                Tile square = new BackGroundTile();
                square.setBackground((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY);
                add(square);
            }
        }
    }

}