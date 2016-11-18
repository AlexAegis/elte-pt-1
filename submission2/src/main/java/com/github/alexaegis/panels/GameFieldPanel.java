package com.github.alexaegis.panels;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.tiles.Tile;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.GRID_DIMENSIONS;

public class GameFieldPanel extends JPanel {

    Color color1 = new Color(180, 180, 180, 240);
    Color color2 = new Color(40, 40, 40, 200);

    public GameFieldPanel(FieldSizeOptions options) {
        setLayout(new GridLayout(options.getN(), options.getM()));
        setPreferredSize(GRID_DIMENSIONS);
        setBounds(0, 0, GRID_DIMENSIONS.width, GRID_DIMENSIONS.height);
        for (int i = 0; i < options.getN(); i++) {
            for (int j = 0; j < options.getM(); j++) {
                Tile tile = new Tile((i + j) % 2 == 0 ? color1 : color2);
                add(tile);
            }
        }
    }
}