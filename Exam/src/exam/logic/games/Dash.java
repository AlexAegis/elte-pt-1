package exam.logic.games;

import exam.utilities.GridTools;
import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.abstraction.GameLogic;
import exam.logic.controllers.PickupMouseController;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static exam.elements.panels.Menu.PAUSEBUTTON;

public class Dash extends AbstractLogic implements GameLogic {

    public Dash() {
        continuousHighLighting = true;
        setValidDirections(Directions.UP, Directions.UPLEFT, Directions.UPRIGHT);
        controller = new PickupMouseController(this);
    }

    @Override
    public void initGame() {
        continuousHighLighting = true;
        controller = new PickupMouseController(this);
        setValidDirections(Directions.UP, Directions.UPLEFT, Directions.UPRIGHT);
        partition(0);
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);
        tileMap.entrySet().stream()
                .filter(entry -> entry.getKey().getX() <= 1)
                .map(Map.Entry::getValue)
                .forEach(tile -> tile.setChild(new Pawn(p1Color, -1, grid.getTileSize())));
        tileMap.entrySet().stream()
                .filter(entry -> entry.getKey().getX() >= grid.getGridHeightByTiles() - 2)
                .map(Map.Entry::getValue)
                .forEach(tile -> tile.setChild(new Pawn(p2Color, 1, grid.getTileSize())));
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        if(firstStep && tileMap.get(coordinate).gotChild() && actualPlayer != ((Pawn)tileMap.get(coordinate).getChild()).getPlayer()) {
             switchActualPlayer();
        }
        List<Directions> currentValidDirections;
        if(actualPlayer == 1) currentValidDirections = validDirections;
        else currentValidDirections = validDirections.stream().map(Directions::opposite).collect(Collectors.toList());
        return currentValidDirections
                .stream()
                .filter(direction -> tileMap.get(coordinate.stepInDirection(direction)) != null
                                        && Arrays.stream(tileMap.get(coordinate.stepInDirection(direction)).getComponents())
                                                .allMatch(component -> !(component instanceof Pawn)
                                                                || (direction.isDiagonal() && ((Pawn)component).getPlayer() != actualPlayer)))
                .map(coordinate::stepInDirection)
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = true;
        Tile parent = to;
        try {
            getTileLocation(to);
            if (Arrays.stream(to.getComponents()).anyMatch(component -> component instanceof Pawn) && validSteps.contains(to)) {
                to.removeChild();
                switchActualPlayer();
            } else if(Arrays.stream(to.getComponents()).anyMatch(component -> component instanceof HighLight)) {
                switchActualPlayer();
            } else {
                result = false;
                parent = from;
            }
        } catch (NoSuchFieldError ignored) {
            parent = from;
        }
        from.removeChild();
        parent.setChild(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        firstStep = false;
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + (actualPawn.getPlayer() == -1 ? "Red" : "Blue"));
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }
        clearActualPawn();
        return result;
    }

    @Override
    public boolean isGameWon() {
        return GridTools.getRowFromGrid(grid, grid.getGridHeightByTiles() - 1).stream()
                .anyMatch(tile -> tile.getComponents().length > 0
                        && tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == -1)
                || GridTools.getRowFromGrid(grid, 0)
                    .stream()
                    .anyMatch(tile -> tile.getComponents().length > 0
                            && tile.getComponent(0) instanceof Pawn
                            && ((Pawn) tile.getComponent(0)).getPlayer() == 1);
    }

    @Override
    public String toString() {
        return "Dash";
    }
}