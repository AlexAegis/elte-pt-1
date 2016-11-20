package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.TILE_SIZE;

public final class HightLight extends JComponent {

    public HightLight() {
        setLayout(new BorderLayout());
    }

    @Override
    public void paint(Graphics graphics) {
       //super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        float[] dist = {0.0f, 1.0f};

        Color[] colors = {new Color(255, 255, 255, 180), new Color(255, 255, 255, 120)};
        g.setPaint(new RadialGradientPaint(TILE_SIZE / 2, TILE_SIZE / 2, TILE_SIZE * 2, dist, colors ));
        g.fillRect(0,0, TILE_SIZE,TILE_SIZE);

        g.setColor(new Color(0, 0, 0, 5));
        g.fillRect(TILE_SIZE / 20 ,TILE_SIZE / 20, TILE_SIZE - TILE_SIZE / 10,TILE_SIZE - TILE_SIZE / 10);

    }

}