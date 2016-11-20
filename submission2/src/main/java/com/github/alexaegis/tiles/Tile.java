package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.TILE_SIZE;

public final class Tile extends JComponent {

    private float[] dist = {0.05f, 1f};

    private Paint paint;

    public Tile(Color color) {
        setLayout(new BorderLayout());
        Color[] colors = {color, new Color(255,255,255,200)};
        paint = new RadialGradientPaint(TILE_SIZE / 2, TILE_SIZE / 2, TILE_SIZE * 5, dist, colors);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(0,0, TILE_SIZE,TILE_SIZE);
    }

}