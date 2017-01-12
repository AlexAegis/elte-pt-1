package exam.logic.games;

import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;

import java.util.List;

public class MasterMind extends AbstractLogic {

    @Override
    public void initGame() {

    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return null;
    }

    @Override
    public void evaluateStep(Tile from, Tile to) {

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
