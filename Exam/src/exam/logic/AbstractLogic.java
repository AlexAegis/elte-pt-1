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
    protected Grid grid;
    protected int maxRng;
    protected int minRng;

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void setRng(int minRng, int maxRng) {
        this.minRng = minRng;
        this.maxRng = maxRng;
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
        for (int i = 0; i < grid.getGridWidthByTiles() && !foundThePawn; i++) {
            for (int j = 0; j < grid.getGridHeightByTiles() && !foundThePawn; j++) {
                foundThePawn = grid.getComponentAt(grid.getTileWidthByPixels() * i, grid.getTileHeightByPixels() * j) == pawn.getParent();
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

    @Override
    public String toString() {
        return "AbstractLogic";
    }
}