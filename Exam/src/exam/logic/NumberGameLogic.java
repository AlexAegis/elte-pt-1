package exam.logic;

import exam.tiles.Number;
import exam.tiles.Pawn;
import exam.tiles.Tile;

import java.awt.*;
import java.util.List;

import static exam.config.Config.DEBUG_MODE;


public class NumberGameLogic extends AbstractLogic implements GameLogic {

    @Override
    public void initGame() {
        if(DEBUG_MODE) {
            System.out.println("INIT WITH DATA: "
                    + "\nTILE HEIGHT: " + grid.getTileHeightByPixels()
                    + "\nTILE WIDTH: " + grid.getTileWidthByPixels()
                    + "\nGRID HEIGHT BY TILES: " + grid.getGridHeightByTiles()
                    + "\nGRID WIDTH BY TILES: " + grid.getGridWidthByTiles()
                    + "\nGRID HEIGHT BY PIXELS: " + grid.getGridWidthByPixels()
                    + "\nGRID WIDTH BY PIXELS: " + grid.getGridWidthByPixels()
                    + "\nMIN RNG: " + minRng
                    + "\nMAX RNG: " + maxRng);
        }
        //grid.getTiles().get(0).forEach(tile -> tile.add(new Pawn(Color.BLUE, 1, grid.getTileWidthByPixels(),grid.getTileHeightByPixels())));
        grid.getTiles().forEach(row -> row.forEach(tile -> tile.add(new Number((int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng), grid.getTileWidthByPixels(), grid.getTileHeightByPixels()))));
    }

    @Override
    public List<Tile> getValidSteps() {
        return null;
    }

    @Override
    public void evaluateClick(int x, int y) {
        if(DEBUG_MODE) System.out.println("Evaluate Click at:" + x + ", " + y);
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
