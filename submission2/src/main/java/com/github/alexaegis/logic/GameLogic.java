package com.github.alexaegis.logic;

import com.github.alexaegis.panels.GameFieldPanel;
import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import java.awt.*;

import java.util.List;

public interface GameLogic {

    void initGame(FieldSizeOptions option);

    List<Tile> getValidSteps();

    void setActualGamePanel(GameFieldPanel actualGamePanel);

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
