package exam.logic.games;

import exam.elements.tiles.Pawn;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.abstraction.GameLogic;
import exam.elements.tiles.HighLight;
import exam.elements.tiles.Number;
import exam.elements.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static exam.config.Config.DEBUG_MODE;
import static exam.config.Config.HIGHLIGHTING;

public class NumberGame extends AbstractLogic implements GameLogic {

    private boolean limited;

    public NumberGame() {
        continuusHighLighting = true;
        setLimited(true);
        setValidDirections(Directions.LEFT, Directions.RIGHT);
        setActualPawn(new Pawn(Color.BLUE, 1, 1, 1));
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public void setValidDirections(Directions... directions) {
        validDirections.clear();
        Arrays.stream(directions).forEach(validDirections::add);
    }


    @Override
    public void initGame() {
        if(DEBUG_MODE) {
            System.out.println("INIT WITH DATA: "
                    + "\nTILE HEIGHT: " + grid.getTileHeightByPixels()
                    + "\nTILE WIDTH: " + grid.getTileWidthByPixels()
                    + "\nGRID HEIGHT BY TILES: " + grid.getGridHeightByTiles()
                    + "\nGRID WIDTH BY TILES: " + grid.getGridWidthByTiles()
                    + "\nGRID HEIGHT BY PIXELS: " + grid.getGridWidthByPixels()
                    + "\nGRID WIDTH BY PIXELS: " + grid.getGridWidthByPixels()
                    + "\nMIN RNG: " + minRng
                    + "\nMAX RNG: " + maxRng);
        }
        tileMap.values().forEach(tile -> tile.setChild(new Number(
                (int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng),
                grid.getTileWidthByPixels(),
                grid.getTileHeightByPixels())));/*
        int n = 0;
        for(Tile tile : tileMap.values()) {
            tile.setChild(new Number(n,
                    grid.getTileWidthByPixels(),
                    grid.getTileHeightByPixels()));
            n += 1;
        }*/
    }

    @Override
    public void setValidSteps(Tile tile) {
        validSteps.add(tile);
        for(Directions direction : validDirections) {
            Coordinate tileLocation = getTileLocation(tile).stepInDirection(direction);
            Tile currentTile = tileMap.get(tileLocation);
            while(currentTile != null) {
                validSteps.add(currentTile);
                tileLocation = tileLocation.stepInDirection(direction);
                currentTile = tileMap.get(tileLocation);
            }
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public void evaluateStep(JComponent from, JComponent to) {
        validSteps.forEach(t -> {
            if(limited) {
                if(((Number)t.getChild()).modifiable(modifier, minRng, maxRng)) {
                    ((Number)t.getChild()).modifyValue(modifier);
                } else {
                    if(modifier > 0) {
                        ((Number)t.getChild()).setValue(maxRng);
                    } else {
                        ((Number)t.getChild()).setValue(minRng);
                    }
                }
            } else {
                ((Number)t.getChild()).modifyValue(modifier);
            }
            t.revalidate();
            t.repaint();
        });
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game Ended");
        }
    }

    @Override
    public boolean isGameWon() {
        boolean won = false;/*
        Iterator iterator = grid.iterator();
        while (iterator.hasNext()) {
            Tile actualTile = tileMap.get((Coordinate)iterator.next());
            won = won || ((Number)actualTile.getChild()).getValue() == 0;
            actualTile.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
        }*/
        return won;
    }

    @Override
    public String toString() {
        return "NumberGame";
    }
}