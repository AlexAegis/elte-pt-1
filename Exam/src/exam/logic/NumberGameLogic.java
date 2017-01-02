package exam.logic;

import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.abstraction.GameLogic;
import exam.tiles.HighLight;
import exam.tiles.Number;
import exam.tiles.Tile;

import javax.swing.*;
import java.util.*;

import static exam.config.Config.DEBUG_MODE;


public class NumberGameLogic extends AbstractLogic implements GameLogic {

    private int modifier = -1;
    private boolean limited;

    public NumberGameLogic() {
        setLimited(true);
        setValidDirections(Directions.LEFT, Directions.RIGHT);
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
        validSteps.forEach(validStep -> {
            validStep.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
            validStep.revalidate();
            validStep.repaint();
        });
    }

    @Override
    public void evaluateClick(Tile tile) {
        validSteps.forEach(t -> {
            if(limited) {
                if(((Number)t.getChild()).modifiable(modifier, minRng, maxRng)) {
                    ((Number)t.getChild()).modifiyValue(modifier);
                }
            } else {
                ((Number)t.getChild()).modifiyValue(modifier);
            }
            t.revalidate();
            t.repaint();
        });
        /*if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game Ended");
        }*/
    }

    @Override
    public boolean isGameWon() {
        boolean won = false;
        Iterator iterator = grid.iterator();
        while (iterator.hasNext()) {
            Tile actualTile = tileMap.get((Coordinate)iterator.next());
            won = won || ((Number)actualTile.getChild()).getValue() == 0;
            actualTile.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
        }
        return won;
    }

    @Override
    public String toString() {
        return "NumberGame";
    }
}