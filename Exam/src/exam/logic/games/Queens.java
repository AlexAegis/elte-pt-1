package exam.logic.games;

import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.PermamentHighLigth;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.BACKBUTTON;
import static exam.elements.panels.Menu.PAUSEBUTTON;
import static exam.elements.panels.Menu.TIMER;

public class Queens extends AbstractLogic {

    private java.util.List<Pawn> steps;
    private boolean firstStep;

    public Queens() {

    }

    @Override
    public void initGame() {
        partition(0);
        continuousHighLighting = true;
        setValidDirections(Directions.UP,
                Directions.UPLEFT,
                Directions.LEFT,
                Directions.DOWNLEFT,
                Directions.DOWN,
                Directions.DOWNRIGHT,
                Directions.RIGHT,
                Directions.UPRIGHT);
        firstStep = true;
        steps = new ArrayList<>();
        TIMER.restart();
        grid.removeMouseListener(controller);
        grid.removeMouseMotionListener((MouseMotionListener) controller);
        controller = new BasicMouseController(this);
        grid.addMouseListener(controller);
        grid.addMouseMotionListener((MouseMotionListener) controller);
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        Arrays.stream(PAUSEBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);
        BACKBUTTON.addActionListener(e -> {
            if(!steps.isEmpty()) {
                Tile prevTile = ((Tile) steps.get(steps.size() - 1).getParent());
                steps.remove(steps.size() - 1);
                prevTile.removeChild();
            }
            grid.revalidate();
            grid.repaint();
        });
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = false;
        if(firstStep) firstStep = false;
        if (validSteps.stream()
                .flatMap(tile -> Stream.of(tile.getComponents()))
                .filter(component -> component.getClass().equals(HighLight.class))
                .map(component -> (HighLight)component)
                .noneMatch(highLight -> highLight.getActualColors().equals(HighLight.warmColors))) {
                    Pawn pawn = new Pawn(Color.black, -1, grid.getTileSize());
                    pawn.promote();
                    setActualPawn(pawn);
                    from.setChild(pawn);
                    steps.add(pawn);
                    result = true;
                }
        /*visibleTiles().stream()
                .filter(tile -> Arrays.stream(tile.getComponents()).noneMatch(component -> component.getClass().equals(PermamentHighLigth.class)))
                .forEach(tile -> tile.add(new PermamentHighLigth(grid.getTileSize()).switchToWeak(), -1));*/
        grid.revalidate();
        grid.repaint();
        if (isGameWon()) {
            JOptionPane.showMessageDialog(null, "You won!!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return result;
    }

    public List<Tile> visibleTiles() {
        return grid.getTiles()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(Tile::gotChild)
                .flatMap(tile -> getValidSteps(tile.getCoordinate()).stream())
                .distinct()
                .map(coordinate -> tileMap.get(coordinate))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isGameWon() {
        return visibleTiles().size() == grid.getGridHeightByTiles() * grid.getGridWidthByTiles();
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if (coordinate != null) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if (HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                if(validStep.gotChild()) {
                    validStep.add(new HighLight(grid.getTileSize()).switchToWarm());
                } else {
                    validStep.add(new HighLight(grid.getTileSize()));
                }
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public java.util.List<Coordinate> getValidSteps(Coordinate coordinate) {
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        for(Directions direction : validDirections) {
            Coordinate current = coordinate.stepInDirection(direction);
            while(tileMap.containsKey(current)) {
                coordinates.add(current);
                current = current.stepInDirection(direction);
            }
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return "Queens";
    }
}