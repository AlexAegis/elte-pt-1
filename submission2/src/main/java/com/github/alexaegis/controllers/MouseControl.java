package com.github.alexaegis.controllers;

import com.github.alexaegis.logic.GameModes;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.github.alexaegis.panels.GamePanel.xOffset;
import static com.github.alexaegis.panels.GamePanel.yOffset;

public class MouseControl implements MouseListener, MouseMotionListener {

    private int x;
    private int y;
    private JLayeredPane game;
    private JPanel gameField;
    private Component original;

    private GameModes gameMode;

    public MouseControl(GameModes gameMode) {
        this.gameMode = gameMode;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game = (JLayeredPane) e.getSource();
        gameField = (JPanel) game.getParent();
        try {
            Pawn pawn = (Pawn) gameField.findComponentAt(e.getX(), e.getY());
            if (!gameMode.currentPlayersPawn(pawn)) {
                return;
            }
            gameMode.setActualPawn(pawn);

            original = pawn.getParent();

            Point parentLocation = pawn.getParent().getLocation();
            x = parentLocation.x - e.getX();
            y = parentLocation.y - e.getY();

            gameMode.getActualPawn().setLocation(e.getX() + x + xOffset, e.getY() + y + yOffset);

            game.add(gameMode.getActualPawn(), JLayeredPane.DRAG_LAYER);
            game.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        } catch (ClassCastException ex) {
        }
        game.revalidate();
        game.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (gameMode.getActualPawn() == null) {
            return;
        }
        int ix = e.getX() + this.x + xOffset;
        int xMax = game.getWidth() - gameMode.getActualPawn().getWidth();
        ix = Math.min(ix, xMax);
        ix = Math.max(ix, 0);
        int iy = e.getY() + this.y + yOffset;
        int yMax = game.getHeight() - gameMode.getActualPawn().getHeight();
        iy = Math.min(iy, yMax);
        iy = Math.max(iy, 0);
        gameMode.getActualPawn().setLocation(ix, iy);
        //game.repaint(); //INFO can be disabled for better performance
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        game.setCursor(null);

        if (gameMode.getActualPawn() == null) {
            gameMode.clearValidSteps();
            gameMode.clearActualPawn();
            return;
        }

        gameMode.getActualPawn().setVisible(false);
        game.remove(gameMode.getActualPawn());
        gameMode.getActualPawn().setVisible(true);

        int xMax = game.getWidth() - gameMode.getActualPawn().getWidth();
        int ix = Math.min(e.getX(), xMax);
        ix = Math.max(ix, 0);

        int yMax = game.getHeight() - gameMode.getActualPawn().getHeight();
        int iy = Math.min(e.getY(), yMax);
        iy = Math.max(iy, 0);

        gameMode.evaluateStep(gameField.findComponentAt(ix, iy), original);
        game.revalidate();
        game.repaint();
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