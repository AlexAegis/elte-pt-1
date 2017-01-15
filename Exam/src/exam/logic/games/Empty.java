package exam.logic.games;

import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;

import java.util.List;

public class Empty extends AbstractLogic {
    @Override
    public void initGame() {

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
        return "Empty";
    }
}