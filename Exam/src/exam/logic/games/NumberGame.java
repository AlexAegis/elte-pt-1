package exam.logic.games;

import exam.elements.tiles.Pawn;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.elements.tiles.Number;
import exam.elements.tiles.Tile;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;

public class NumberGame extends AbstractLogic {

    private boolean limited;

    public NumberGame() {

    }

    @Override
    public void initGame() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        setLimited(true);
        setValidDirections(Directions.LEFT, Directions.RIGHT);
        partition(0);
        tileMap.values().forEach(tile -> tile.setChild(new Number(
                (int) (((Math.random() * 100) % (maxRng - minRng + 1)) + minRng),
                grid.getTileSize())));
    }

    private void setLimited(boolean limited) {
        this.limited = limited;
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if(coordinate != null && tile.gotChild() && (!(tile.getChild() instanceof Pawn) || ((Pawn)tile.getChild()).getPlayer() == actualPlayer)) {
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
        for(Directions direction : validDirections) {
            Coordinate current = coordinate.stepInDirection(direction);
            while(tileMap.get(current) != null) { //set distance here not null is till it hits border
                coordinates.add(current);
                current = current.stepInDirection(direction);
            }
        }
        return coordinates;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        validSteps.forEach(t -> {
            if(limited) {
                if(((Number)t.getChild()).modifiable(modifier, minRng, maxRng)) {
                    ((Number)t.getChild()).modifyValue(modifier);
                } else {
                    if(modifier > 0) {
                        ((Number)t.getChild()).setValue(maxRng);
                    } else {
                        ((Number)t.getChild()).setValue(minRng);
                    }
                }
            } else {
                ((Number)t.getChild()).modifyValue(modifier);
            }
            t.revalidate();
            t.repaint();
        });
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game Ended");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return true;
    }

    @Override
    public boolean isGameWon() {
        int current = 0;
        for (Tile tile : grid) {
            if(((Number)tile.getChild()).getValue() >= current) {
                current = ((Number)tile.getChild()).getValue();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "NumberGame";
    }
}