package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.TILE_SIZE;

public final class Tile extends JComponent {

    private Color originalColor;

    public Tile(Color color) {
        setLayout(new BorderLayout());
        originalColor = color;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(originalColor);
        g.fillRect(0,0, TILE_SIZE,TILE_SIZE);
    }

}