package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public class Pawn extends JComponent {

    private ImageIcon icon;
    private int player;

    private GradientPaint player0Color = new GradientPaint(0, 0, Color.RED,100, 255, Color.getHSBColor(255,255,255));
    private GradientPaint player1Color = new GradientPaint(0, 0, Color.BLUE,100, 255, Color.getHSBColor(0,255,255));

    public Pawn(int player) {
            this.player = player;
            setPreferredSize(new Dimension(GRID_SIZE_DEFAULT / TILE_SIZE, GRID_SIZE_DEFAULT / TILE_SIZE));
            setBackground(Color.WHITE);
            setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(player == 1 ? Color.RED : Color.BLUE);
        g.setPaint(player == 1 ? player0Color : player1Color);
        g.fillOval(0,0, TILE_SIZE,TILE_SIZE);
    }

    public int getPlayer() {
        return player;
    }
    
    public int getOtherPlayer() {
        return player == 0 ? 1 : 0;
    }

}