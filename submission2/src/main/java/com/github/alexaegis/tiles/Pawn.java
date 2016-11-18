package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public final class Pawn extends JComponent {

    private ImageIcon icon;
    private int player;

    private GradientPaint player0Color = new GradientPaint(0, 0, new Color(220,60, 40, 255),100, 255, new Color(220,160, 100, 230));
    private GradientPaint player1Color = new GradientPaint(0, 0, new Color(40,40, 200, 255),100, 255, new Color(160,200, 220, 230));

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
        g.setPaint(player == 1 ? player0Color : player1Color);
        g.fillOval(0,0, TILE_SIZE,TILE_SIZE);
    }

    public int getPlayer() {
        return player;
    }

    public int getOtherPlayer() {
        return player == 0 ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pawn pawn = (Pawn) o;

        if (player != pawn.player) return false;
        return icon != null ? icon.equals(pawn.icon) : pawn.icon == null;

    }

    @Override
    public int hashCode() {
        int result = icon != null ? icon.hashCode() : 0;
        result = 31 * result + player;
        return result;
    }
}