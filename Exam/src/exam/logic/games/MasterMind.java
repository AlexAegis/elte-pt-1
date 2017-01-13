package exam.logic.games;

import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;

import java.util.List;

public class MasterMind extends AbstractLogic {

    @Override
    public void initGame() {
        // RIGHTMOST COLUMN LABEL INSERTION
        /*
        Coordinate rightMost = new Coordinate(0, grid.getGridWidthByTiles() - 1);
        do {
            tileMap.get(rightMost).add(new HintLabel());
            rightMost = rightMost.stepInDirection(Directions.DOWN);
        } while (tileMap.get(rightMost) != null);*/
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
