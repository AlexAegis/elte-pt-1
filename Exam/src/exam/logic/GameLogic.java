package exam.logic;


import exam.panels.Grid;
import exam.tiles.Pawn;
import exam.tiles.Tile;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface GameLogic {

    void initGame();

    List<Tile> getValidSteps(Tile tile);

    void setGrid(Grid grid);

    void clearValidSteps();

    boolean currentPlayersPawn(Pawn pawn);

    int getActualPlayer();

    int[] findPawn(Pawn pawn);

    void setActualPawn(Pawn pawn);

    Pawn getActualPawn();

    void clearActualPawn();

    void switchActualPlayer();

    void evaluateClick(Tile tile);

    boolean isGameWon();

    void setTarget(Pawn target);

    void clearTarget();

    String toString();

    void setRng(int minRng, int maxRng);
}