package exam.logic.games;

import exam.elements.tiles.ColorTile;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.PAUSEBUTTON;

public class Task extends AbstractLogic {

    private List<Tile> history;

    public Task() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);

        setValidDirections(Directions.values());
    }

    @Override
    public void initGame() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        setValidDirections(Directions.values());
        history = new ArrayList<>();
        partition(0);
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);

    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if(coordinate != null /*&& tile.getChild() instanceof ColorTile && ((ColorTile) tile.getChild()).isActivated()*/) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) { highlight();}
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        return coordinates;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        System.out.println(from.getCoordinate());
        System.out.println(to.getCoordinate());
        return false;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public String toString() {
        return "Task";
    }
}