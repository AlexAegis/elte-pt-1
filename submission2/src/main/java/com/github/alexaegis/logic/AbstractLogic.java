package com.github.alexaegis.logic;

import com.github.alexaegis.panels.GameFieldPanel;
import com.github.alexaegis.tiles.HightLight;
import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public abstract class AbstractLogic implements GameLogic {

    protected int actualPlayer = -1;
    protected Pawn actualPawn;
    protected Pawn target;
    protected List<Tile> validSteps = new ArrayList<>();
    protected GameFieldPanel actualGamePanel;

    @Override
    public void setActualGamePanel(GameFieldPanel actualGamePanel) {
        this.actualGamePanel = actualGamePanel;
    }

    @Override
    public void clearValidSteps() {
        validSteps.stream().flatMap(valid -> Stream.of(valid.getComponents()))
                .filter(component -> component instanceof HightLight)
                .forEach(highLight -> highLight.getParent().remove(highLight));
        validSteps.clear();
    }

    @Override
    public boolean currentPlayersPawn(Pawn pawn) {
        return pawn.getPlayer() == getActualPlayer();
    }

    @Override
    public int getActualPlayer() {
        return actualPlayer;
    }

    @Override
    public int[] findPawn(Pawn pawn) {
        boolean foundThePawn = false;
        for (int i = 0; i < GRID_SIZE_DEFAULT / TILE_SIZE && !foundThePawn; i++) {
            for (int j = 0; j < GRID_SIZE_DEFAULT / TILE_SIZE && !foundThePawn; j++) {
                foundThePawn = actualGamePanel.getComponentAt(TILE_SIZE * i, TILE_SIZE * j) == pawn.getParent();
                if(foundThePawn) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Override
    public void setActualPawn(Pawn pawn) {
        actualPawn = pawn;
        getValidSteps();
    }

    @Override
    public void setTarget(Pawn target) {
        this.target = target;
    }

    @Override
    public void clearTarget() {
        target = null;
    }

    @Override
    public Pawn getActualPawn() {
        return actualPawn;
    }

    @Override
    public void clearActualPawn() {
        actualPawn = null;
    }

    @Override
    public void switchActualPlayer() {
        actualPlayer = 0 - actualPlayer;
    }

}