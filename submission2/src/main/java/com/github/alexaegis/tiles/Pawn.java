package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public final class Pawn extends JComponent {

    private int player;
    private boolean promoted = false;

    private static GradientPaint player0Color = new GradientPaint(0, 0, new Color(220,60, 40, 255),100, 255, new Color(220,160, 100, 230));
    private static GradientPaint player0PromotedColor = new GradientPaint(0, 0, new Color(182, 14, 47, 255),100, 255, new Color(220, 61, 46, 230));
    private static GradientPaint player1Color = new GradientPaint(0, 0, new Color(0, 110, 180, 255),100, 255, new Color(160,200, 220, 230));
    private static GradientPaint player1PromotedColor = new GradientPaint(0, 0, new Color(109, 93, 220, 255),100, 255, new Color(141, 48, 247, 230));
    private GradientPaint actualColor;

    public Pawn(int player) {
        this.player = player;
        actualColor = (player == 1) ? player0Color : player1Color;
        setPreferredSize(new Dimension(GRID_SIZE_DEFAULT / TILE_SIZE, GRID_SIZE_DEFAULT / TILE_SIZE));
        setVisible(true);
    }

    public void promote() {
        promoted = true;
        actualColor = (player == 1) ? player0PromotedColor : player1PromotedColor;
        repaint();
    }

    public void demote() {
        promoted = false;
        actualColor = (player == 1) ? player0Color : player1Color;
        repaint();
    }

    public boolean isPromoted() {
        return promoted;
    }

    public Pawn takeOff() {
        this.getParent().remove(this);
        return this;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(actualColor);
        g.fillOval(0,0, TILE_SIZE,TILE_SIZE);
    }

    public int getPlayer() {
        return player;
    }

    public static GradientPaint getPlayer0Color() {
        return player0Color;
    }

    public static GradientPaint getPlayer1Color() {
        return player1Color;
    }

    @Override
    public String toString() {
        return (player == 1) ? "Red" : "Blue";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pawn pawn = (Pawn) o;

        return player == pawn.player;

    }

    @Override
    public int hashCode() {
        return player;
    }
}