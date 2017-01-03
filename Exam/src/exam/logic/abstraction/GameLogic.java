package exam.logic.abstraction;


import exam.elements.panels.Grid;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;

import java.util.List;

public interface GameLogic {

    void initGame();

    void setGrid(Grid grid);

    void setValidSteps(Tile tile);

    void setValidDirections(List<Directions> directions);

    void setRng(int minRng, int maxRng);

    void clearValidSteps();

    void evaluateClick(Tile tile);

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