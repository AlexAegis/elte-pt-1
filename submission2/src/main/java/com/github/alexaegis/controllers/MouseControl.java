package com.github.alexaegis.controllers;

import com.github.alexaegis.tiles.Tile;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.github.alexaegis.panels.GamePanel.xOffset;
import static com.github.alexaegis.panels.GamePanel.yOffset;

public class MouseControl implements MouseListener, MouseMotionListener {

    private JLabel pawn;
    private int x;
    private int y;
    private JLayeredPane game;
    private JPanel gameField;
    private Component original;

    @Override
    public void mousePressed(MouseEvent e) {
        game = (JLayeredPane) e.getSource();
        gameField = (JPanel) game.getParent();
        pawn = null;
        Component c = gameField.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) {
            return;
        }
        original = c.getParent();

        Point parentLocation = c.getParent().getLocation();
        x = parentLocation.x - e.getX();
        y = parentLocation.y - e.getY();
        pawn = (JLabel)c;
        pawn.setLocation(e.getX() + x + xOffset, e.getY() + y + yOffset);

        game.add(pawn, JLayeredPane.DRAG_LAYER);
        game.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pawn == null) {
            return;
        }

        int x = e.getX() + this.x + xOffset;
        int xMax = game.getWidth() - pawn.getWidth();
        x = Math.min(x, xMax);
        x = Math.max(x, 0);

        int y = e.getY() + this.y + yOffset;
        int yMax = game.getHeight() - pawn.getHeight();
        y = Math.min(y, yMax);
        y = Math.max(y, 0);

        pawn.setLocation(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        game.setCursor(null);

        if (pawn == null) {
            return;
        }

        pawn.setVisible(false);
        game.remove(pawn);
        pawn.setVisible(true);

        int xMax = game.getWidth() - pawn.getWidth();
        int x = Math.min(e.getX(), xMax);
        x = Math.max(x, 0);

        int yMax = game.getHeight() - pawn.getHeight();
        int y = Math.min(e.getY(), yMax);
        y = Math.max(y, 0);

        Component c = gameField.findComponentAt(x, y);

        if (c instanceof Pawn) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(pawn);
            parent.validate();
        }
        else if(c instanceof Tile) {
            Container parent = (Container)c;
            parent.add(pawn);
            parent.validate();
        }
        else {
            Container parent = (Container) original;
            parent.add(pawn);
            parent.repaint();
            parent.validate();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}