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
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.DEBUG_MODE;
import static exam.config.Config.HIGHLIGHTING;

public class NumberGame extends AbstractLogic {

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

    @Override
    public void initGame() {
        tileMap.values().forEach(tile -> tile.setChild(new Number(
                (int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng),
                grid.getTileWidthByPixels(),
                grid.getTileHeightByPixels())));
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        for(Directions direction : validDirections) {
            Coordinate current = coordinate.stepInDirection(direction);
            while(tileMap.get(current) != null) {
                coordinates.add(current);
                current = current.stepInDirection(direction);
            }
        }
        return coordinates;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
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
        return true;
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