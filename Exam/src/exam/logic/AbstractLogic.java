package exam.logic;


import exam.panels.Grid;
import exam.tiles.HighLight;
import exam.tiles.Pawn;
import exam.tiles.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public abstract class AbstractLogic implements GameLogic {

    protected int actualPlayer = -1;
    protected Pawn actualPawn;
    protected Pawn target;
    protected List<Tile> validSteps = new ArrayList<>();
    protected Grid actualGrid;
    protected int tileWidth;
    protected int tileHeight;
    protected int gridWidth;
    protected int gridHeight;

    @Override
    public void setActualGrid(Grid actualGrid) {
        this.actualGrid = actualGrid;
        this.gridWidth = actualGrid.getTiles().size();
        this.gridHeight = actualGrid.getTiles().get(0).size();
        this.tileHeight = actualGrid.getTiles().get(0).get(0).getHeight();
        this.tileWidth = actualGrid.getTiles().get(0).get(0).getWidth();
    }

    @Override
    public void clearValidSteps() {
        validSteps.stream().flatMap(valid -> Stream.of(valid.getComponents()))
                .filter(component -> component instanceof HighLight)
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
        for (int i = 0; i < gridWidth && !foundThePawn; i++) {
            for (int j = 0; j < gridHeight && !foundThePawn; j++) {
                foundThePawn = actualGrid.getComponentAt(tileWidth * i, tileHeight * j) == pawn.getParent();
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