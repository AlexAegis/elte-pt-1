package exam.logic.games;

import exam.elements.tiles.ColorTile;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static exam.config.Utilities.getColumnFromGrid;
import static exam.config.Utilities.getColumnsFromGrid;

public class MasterMind extends AbstractLogic {

    private List<ColorTile> solution = new ArrayList<>();
    private List<List<Tile>> tiles;
    private List<Tile> hints;

    public MasterMind() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        setValidDirections(Directions.LEFT, Directions.RIGHT);
    }

    @Override
    public void initGame() {
        tiles = getColumnsFromGrid(grid, 0, grid.getGridWidthByTiles() - 2);
        hints = getColumnFromGrid(grid, grid.getGridWidthByTiles() - 1);

        hints.forEach(tile -> {
            tile.setChild(new Pawn(Color.black, 1, 50,50 ));
        });

        tiles.forEach(row-> row.forEach(tile -> {
            tile.setChild(new Pawn(Color.red, 1, 50,50 ));
        }));
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return null;
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
    public String toString() {
        return "MasterMind";
    }
}
