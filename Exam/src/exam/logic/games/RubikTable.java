package exam.logic.games;

import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

import static exam.elements.panels.Menu.STEPCOUNTER;

public class RubikTable extends AbstractLogic {

    public RubikTable() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
    }

    @Override
    public void initGame() {


        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "You won at the round: " + STEPCOUNTER.getText());
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }

    }

    private java.util.List<Tile> getRow(java.util.List<java.util.List<Tile>> tiles, int n) {
        if(n < 0 || n > grid.getGridHeightByTiles()) throw new IndexOutOfBoundsException();
        return tiles.stream()
                .flatMap(Collection::stream)
                .filter(tile -> tile.getCoordinate().getX() == n)
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {

        return true;
    }

    @Override
    public boolean isGameWon() {
        return true;
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