package exam.logic.games;

import exam.elements.tiles.Pawn;
import exam.elements.tiles.Rotator;
import exam.elements.tiles.Shade;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static exam.elements.panels.Menu.STEPCOUNTER;

public class RubikTable extends AbstractLogic {

    private List<Color> allColors;

    public RubikTable() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        allColors = new ArrayList<>();
        allColors.add(Color.red);
        allColors.add(Color.blue);
        allColors.add(Color.yellow);
        allColors.add(Color.green);
        allColors.add(Color.white);
        allColors.add(Color.black);
    }

    @Override
    public void initGame() { //TODO ADD THIS PARTITION TO THE ABSTRACTION, REFACTOR GAMES ACCORDINGLY
        partition(1);
        allColors = new ArrayList<>();


        //tiles.forEach(tiles1 -> tiles1.forEach(tile -> tile.setChild(new Shade(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()))));

        upperButtons.forEach(tile -> tile.setChild(new Rotator(Directions.DOWN, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        lowerButtons.forEach(tile -> tile.setChild(new Rotator(Directions.UP, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        leftButtons.forEach(tile -> tile.setChild(new Rotator(Directions.RIGHT, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        rightButtons.forEach(tile -> tile.setChild(new Rotator(Directions.LEFT, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));


        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "You won at the round: " + STEPCOUNTER.getText());
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }

    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {

        return true;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public void setValidSteps(Tile tile) {

    }

    @Override
    public java.util.List<Coordinate> getValidSteps(Coordinate coordinate) {
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        return coordinates;
    }

    @Override
    public String toString() {
        return "Rubik Table";
    }
}