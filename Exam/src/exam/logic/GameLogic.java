package exam.logic;


import exam.panels.Grid;
import exam.tiles.Pawn;
import exam.tiles.Tile;

import java.awt.*;
import java.util.List;

public interface GameLogic {

    void initGame();

    List<Tile> getValidSteps();

    void setActualGrid(Grid actualGrid);

    void clearValidSteps();

    boolean currentPlayersPawn(Pawn pawn);

    int getActualPlayer();

    int[] findPawn(Pawn pawn);

    void setActualPawn(Pawn pawn);

    Pawn getActualPawn();

    void clearActualPawn();

    void switchActualPlayer();

    void evaluateStep(Component destination, Component original);

    boolean isGameWon();

    void setTarget(Pawn target);

    void clearTarget();

}