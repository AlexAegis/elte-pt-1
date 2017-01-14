package exam.logic.abstraction;


import exam.elements.labels.PlayerIndicator;
import exam.elements.panels.Grid;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public interface GameLogic {

    void partition(int padding);

    void initGame();

    boolean isContinuousHighLighting();

    void setGrid(Grid grid);

    void setValidSteps(Tile tile);

    List<Coordinate> getValidSteps(Coordinate coordinate);

    void setValidDirections(Directions... directions);

    void setModifier(int mod);

    void setRng(int minRng, int maxRng);

    void clearValidSteps();

    boolean evaluateStep(Tile from, Tile to);

    boolean currentPlayersPawn(Pawn pawn);

    int getActualPlayer();

    Coordinate getTileLocation(Tile tile);

    Coordinate findPawn(Pawn pawn);

    void setActualPawn(Pawn pawn);

    Pawn getActualPawn();

    void clearActualPawn();

    void switchActualPlayer();

    boolean isGameWon();

    void setTarget(Pawn target);

    void clearTarget();

    String toString();

    void setIndicator(PlayerIndicator playerindicator);

    MouseListener getMouseListener();

    MouseMotionListener getMouseMotionListener();

    void highlight();
}