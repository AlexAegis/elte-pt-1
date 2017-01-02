package exam.logic;

import exam.tiles.Number;
import exam.tiles.Tile;
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
        tileMap.values().forEach(tile -> tile.add(new Number(
                (int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng),
                grid.getTileWidthByPixels(),
                grid.getTileHeightByPixels())));
    }

    @Override
    public List<Tile> getValidSteps(Tile tile) {
        return null;
    }

    @Override
    public void evaluateClick(Tile tile) {
        if(DEBUG_MODE) System.out.println("Evaluate Click at:");
    }

    @Override
    public boolean isGameWon() {
        return false;    }

    @Override
    public String toString() {
        return "NumberGame";
    }
}