package exam.logic;

import exam.tiles.HighLight;
import exam.tiles.Number;
import exam.tiles.Tile;
import java.util.HashSet;
import java.util.Set;

import static exam.config.Config.DEBUG_MODE;


public class NumberGameLogic extends AbstractLogic implements GameLogic {

    private Set<Directions> validDirections = new HashSet<>();
    private int modifier = -1;

    public NumberGameLogic() {
        validDirections.add(Directions.LEFT);
        validDirections.add(Directions.RIGHT);
        validDirections.add(Directions.UP);
        validDirections.add(Directions.DOWN);
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
        validSteps.forEach(t -> ((Number)t.getChildren()).modifiyValue(modifier));
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