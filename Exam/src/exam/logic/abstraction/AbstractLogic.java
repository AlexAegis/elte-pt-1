package exam.logic.abstraction;


import exam.elements.labels.PlayerIndicator;
import exam.elements.panels.Grid;
import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static exam.config.Config.HIGHLIGHTING;


public abstract class AbstractLogic implements GameLogic {

    protected static final Color p1Color = new Color(255, 83, 72,255);
    protected static final Color p2Color = new Color(67, 105, 243,255);

    protected int actualPlayer = -1;
    protected Pawn actualPawn;
    protected Pawn target;
    protected int maxRng;
    protected int minRng;
    protected int modifier;
    protected List<Tile> validSteps = new ArrayList<>();
    protected List<Directions> validDirections = new ArrayList<>();
    protected Grid grid;
    protected Map<Coordinate, Tile> tileMap;
    protected boolean continuusHighLighting = false;

    protected PlayerIndicator indicator;

    @Override
    public void setIndicator(PlayerIndicator indicator) {
        this.indicator = indicator;
    }

    public void setIndicatorColor(Color color) {
        indicator.setIndicatorColor(color);
    }

    @Override
    public void setValidDirections(Directions... directions) {
        validDirections.clear();
        Arrays.stream(directions).forEach(validDirections::add);
    }


    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = getTileLocation(tile);
        if(coordinate != null) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileHeightByPixels(), grid.getTileWidthByPixels()));
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public boolean isContinuusHighLighting() {
        return continuusHighLighting;
    }

    @Override
    public void setModifier(int mod) {
        this.modifier = mod;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
        this.tileMap = grid.getTiles();
    }

    @Override
    public void setRng(int minRng, int maxRng) {
        this.minRng = minRng;
        this.maxRng = maxRng;
    }

    @Override
    public Coordinate getTileLocation(Tile tile) {
        return tileMap.entrySet().stream()
                .filter(coordinateTileEntry -> coordinateTileEntry.getValue().equals(tile))
                .findFirst()
                .orElseThrow(NoSuchFieldError::new)
                .getKey();
    }

    @Override
    public void clearValidSteps() {
        validSteps.stream().flatMap(valid -> Stream.of(valid.getComponents()))
                .filter(component -> component instanceof HighLight)
                .forEach(highLight -> highLight.getParent().remove(highLight));
        grid.revalidate();
        grid.repaint();
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
    public Coordinate findPawn(Pawn pawn) {
        boolean foundThePawn = false;
        for (int i = 0; i < grid.getGridWidthByTiles() && !foundThePawn; i++) {
            for (int j = 0; j < grid.getGridHeightByTiles() && !foundThePawn; j++) {
                try {
                    foundThePawn = grid.getComponentAt(grid.getTileWidthByPixels() * i, grid.getTileHeightByPixels() * j) == pawn.getParent();
                    if(foundThePawn) {
                        return new Coordinate(i, j);
                    }
                } catch (NullPointerException e) {

                }
            }
        }
        return null;
    }

    @Override
    public void setActualPawn(Pawn pawn) {
        actualPawn = pawn;
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
        setIndicatorColor(actualPlayer == 1 ? p2Color : p1Color);
    }

    @Override
    public String toString() {
        return "AbstractLogic";
    }
}