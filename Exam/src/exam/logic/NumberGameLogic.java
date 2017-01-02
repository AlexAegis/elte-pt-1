package exam.logic;

import exam.tiles.Tile;

import java.awt.*;
import java.util.List;


public class NumberGameLogic extends AbstractLogic implements GameLogic {

    @Override
    public void initGame() {

    }

    @Override
    public List<Tile> getValidSteps() {
        return null;
    }

    @Override
    public void evaluateClick(int x, int y) {
        System.out.println(x + " + " + y);
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public String toString() {
        return "NumberGame";
    }
}
