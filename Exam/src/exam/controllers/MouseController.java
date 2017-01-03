package exam.controllers;

import exam.elements.labels.StepCounterLabel;
import exam.logic.abstraction.GameLogic;
import exam.elements.tiles.Tile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static exam.elements.panels.Menu.STEPCOUNTERLABEL;

public class MouseController implements MouseListener, MouseMotionListener {

    private GameLogic gameLogic;

    public MouseController(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            gameLogic.evaluateClick((Tile) e.getComponent().getComponentAt(e.getX(), e.getY()));
            STEPCOUNTERLABEL.increase();
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gameLogic.clearValidSteps();
        try {
            gameLogic.setValidSteps((Tile) e.getComponent().getComponentAt(e.getX(), e.getY()));
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gameLogic.clearValidSteps();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}