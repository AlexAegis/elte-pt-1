package exam.controllers;


import exam.logic.GameLogic;
import exam.panels.Game;
import exam.panels.Grid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseListener {

    private Grid grid;
    private GameLogic gameLogic;

    public MouseController(Grid grid, GameLogic gameLogic) {
        this.grid = grid;
        this.gameLogic = gameLogic;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}