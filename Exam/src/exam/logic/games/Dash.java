package exam.logic.games;

import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.abstraction.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Dash extends AbstractLogic implements GameLogic {

    public Dash() {
        continuusHighLighting = false;
        setValidDirections(Directions.UP, Directions.UPLEFT, Directions.UPRIGHT);
    }

    @Override
    public void initGame() {
        tileMap.entrySet().stream()
                .filter(entry -> entry.getKey().getX() <= 1)
                .map(Map.Entry::getValue)
                .forEach(tile -> tile.add(new Pawn(p1Color, -1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        tileMap.entrySet().stream()
                .filter(entry -> {
                    if(entry.getKey().getX() >= grid.getGridHeightByTiles() - 2) {

                        System.out.println("x" + entry.getKey().getX() + "ghbTiles:" + grid.getGridHeightByTiles());
                    }
                    return entry.getKey().getX() >= grid.getGridHeightByTiles() - 2;
                })
                .map(Map.Entry::getValue)
                .forEach(tile -> tile.add(new Pawn(p2Color, 1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        List<Directions> currentValidDirections;
        if(actualPlayer == 1) currentValidDirections = validDirections;
        else currentValidDirections = validDirections.stream().map(Directions::turnVertical).collect(Collectors.toList());
        return currentValidDirections
                .stream()
                .filter(direction -> tileMap.get(coordinate.stepInDirection(direction)) != null
                                        && Arrays.stream(tileMap.get(coordinate.stepInDirection(direction)).getComponents())
                                                .allMatch(component -> !(component instanceof Pawn) || direction.isDiagonal()))
                .map(coordinate::stepInDirection)
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = true;
        System.out.println(getTileLocation(from).toString());
        System.out.println(getTileLocation(to).toString());
        Tile parent = to;
        if (Arrays.stream(to.getComponents()).anyMatch(component -> component instanceof Pawn) && validSteps.contains(to)) {
            System.out.println("1");
            ((Pawn)to.getChild()).takeOff();
            switchActualPlayer();
        } else if(Arrays.stream(to.getComponents()).anyMatch(component -> component instanceof HighLight) ) {
            System.out.println("2");
            parent = to;
            switchActualPlayer();
        } else {
            result = false;
            System.out.println("3");
            parent = from;
        }
        parent.setChild(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + (actualPawn.getPlayer() == 1 ? "Red" : "Blue"));
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }
        clearActualPawn();
        return result;
    }

    @Override
    public boolean isGameWon() {
        ArrayList<Tile> goal1 = new ArrayList<>(); // Blue dest
        ArrayList<Tile> goal2 = new ArrayList<>(); // Red dest
        for (int i = 0; i < grid.getGridWidthByTiles(); i++) {
            goal1.add((Tile) grid.getComponent(grid.getComponents().length - i - 1));
            goal2.add((Tile) grid.getComponent(i));
        }
        return goal1.stream()
                .anyMatch(tile -> tile.getComponents().length > 0 &&
                        tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == -1) ||
                goal2.stream().anyMatch(tile -> tile.getComponents().length > 0 && tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == 1);
    }

    @Override
    public String toString() {
        return "Dash";
    }
}