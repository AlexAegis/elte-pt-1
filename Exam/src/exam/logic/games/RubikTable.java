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

import static exam.config.Utilities.*;
import static exam.elements.panels.Menu.STEPCOUNTER;

public class RubikTable extends AbstractLogic {

    private List<List<Tile>> tiles;
    private List<Tile> upperButtons;
    private List<Tile> lowerButtons;
    private List<Tile> leftButtons;
    private List<Tile> rightButtons;
    private List<Color> allColors;
    private Tile cornerUpLeft;
    private Tile cornerUpRight;
    private Tile cornerDownLeft;
    private Tile cornerDownRight;

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

        allColors = new ArrayList<>();

        upperButtons = new ArrayList<>();
        lowerButtons = new ArrayList<>();
        leftButtons = new ArrayList<>();
        rightButtons = new ArrayList<>();

        leftButtons = getColumnFromGrid(grid, 0);
        rightButtons = getColumnFromGrid(grid, grid.getGridWidthByTiles() - 1);
        upperButtons = getRowFromGrid(grid, 0);
        lowerButtons = getRowFromGrid(grid, grid.getGridHeightByTiles() - 1);

        cornerUpLeft = upperButtons.get(0);
        cornerUpRight = upperButtons.get(upperButtons.size() - 1);
        cornerDownLeft = lowerButtons.get(0);
        cornerDownRight = lowerButtons.get(lowerButtons.size() - 1);

        leftButtons = leftButtons.subList(1, leftButtons.size() - 1);
        rightButtons = rightButtons.subList(1, rightButtons.size() - 1);
        upperButtons = upperButtons.subList(1, upperButtons.size() - 1);
        lowerButtons = lowerButtons.subList(1, lowerButtons.size() - 1);

        tiles = getSquareFromGrid(grid, 1);
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