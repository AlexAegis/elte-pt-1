package com.github.alexaegis.panels;

import com.github.alexaegis.tiles.BackGroundTile;
import com.github.alexaegis.tiles.Tile;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.GRID_DIMENSIONS;
import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;

public class GameField extends JPanel {

    public GameField() {

        setLayout(new GridLayout(GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT));
        setPreferredSize(GRID_DIMENSIONS);
        setBounds(0, 0, GRID_DIMENSIONS.width, GRID_DIMENSIONS.height);
        for (int i = 0; i < GRID_SIZE_DEFAULT; i++) {
            for (int j = 0; j < GRID_SIZE_DEFAULT; j++) {
                Tile square = new BackGroundTile();
                square.setBackground((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY);
                add(square);
            }
        }
    }

}