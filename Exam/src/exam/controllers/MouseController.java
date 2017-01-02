package exam.controllers;

import exam.logic.GameLogic;
import exam.tiles.Tile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseListener, MouseMotionListener {

    private GameLogic gameLogic;

    public MouseController(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gameLogic.clearValidSteps();
        try {
            System.out.println(gameLogic.getTileLocation((Tile) e.getComponent().getComponentAt(e.getX(), e.getY())).toString());
            gameLogic.setValidSteps((Tile) e.getComponent().getComponentAt(e.getX(), e.getY()));
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameLogic.evaluateClick((Tile) e.getComponent().getComponentAt(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        gameLogic.clearValidSteps();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}