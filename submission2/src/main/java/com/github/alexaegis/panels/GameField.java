package com.github.alexaegis.panels;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.tiles.BackGroundTile;
import com.github.alexaegis.tiles.Tile;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.GRID_DIMENSIONS;

public class GameField extends JPanel {

    public GameField(FieldSizeOptions options) {

        setLayout(new GridLayout(options.getN(), options.getM()));
        setPreferredSize(GRID_DIMENSIONS);
        setBounds(0, 0, GRID_DIMENSIONS.width, GRID_DIMENSIONS.height);
        for (int i = 0; i < options.getN(); i++) {
            for (int j = 0; j < options.getM(); j++) {
                Tile square = new BackGroundTile();
                square.setBackground((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY);
                add(square);
            }
        }
    }

}