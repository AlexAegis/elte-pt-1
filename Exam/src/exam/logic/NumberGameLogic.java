package exam.logic;

import exam.tiles.HighLight;
import exam.tiles.Number;
import exam.tiles.Tile;

import java.util.*;

import static exam.config.Config.DEBUG_MODE;


public class NumberGameLogic extends AbstractLogic implements GameLogic {

    private int modifier = -1;
    private boolean limited;

    public NumberGameLogic() {
        setLimited(true);
        setValidDirections(Directions.LEFT, Directions.RIGHT);
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public void setValidDirections(Directions... directions) {
        validDirections.clear();
        Arrays.stream(directions).forEach(validDirections::add);
    }

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
        tileMap.values().forEach(tile -> tile.setChildren(new Number(
                (int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng),
                grid.getTileWidthByPixels(),
                grid.getTileHeightByPixels())));
    }

    @Override
    public void setValidSteps(Tile tile) {
        validSteps.add(tile);
        for(Directions direction : validDirections) {
            Coordinate tileLocation = getTileLocation(tile).stepInDirection(direction);
            Tile currentTile = tileMap.get(tileLocation);
            while(currentTile != null) {
                validSteps.add(currentTile);
                tileLocation = tileLocation.stepInDirection(direction);
                currentTile = tileMap.get(tileLocation);
            }
        }
        validSteps.forEach(validStep -> {
            validStep.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
            validStep.revalidate();
            validStep.repaint();
        });
    }

    @Override
    public void evaluateClick(Tile tile) {
        validSteps.forEach(t -> {
            ((Number)t.getChildren()).modifiyValue(modifier);
            t.revalidate();
            t.repaint();
        });
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