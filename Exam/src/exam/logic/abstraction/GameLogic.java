package exam.logic.abstraction;


import exam.elements.panels.Grid;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface GameLogic {

    void initGame();

    boolean isContinuusHighLighting();

    void setGrid(Grid grid);

    void setValidSteps(Tile tile);

    void setValidDirections(List<Directions> directions);

    void setRng(int minRng, int maxRng);

    void clearValidSteps();

    void evaluateStep(JComponent from, JComponent to);

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
}