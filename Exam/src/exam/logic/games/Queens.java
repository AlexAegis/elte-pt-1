package exam.logic.games;

import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.*;
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
        continuousHighLighting = true;
        validDirections.add(Directions.UP);
        validDirections.add(Directions.UPLEFT);
        validDirections.add(Directions.LEFT);
        validDirections.add(Directions.DOWNLEFT);
        validDirections.add(Directions.DOWN);
        validDirections.add(Directions.DOWNRIGHT);
        validDirections.add(Directions.RIGHT);
        validDirections.add(Directions.UPRIGHT);
    }

    @Override
    public void initGame() {
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
                    /*getValidSteps(getTileLocation((Tile) pawn.getParent())).stream()
                            .map(coordinate -> tileMap.get(coordinate))
                            .filter(tile -> Stream.of(tile.getComponents()).anyMatch(component -> !component.getClass().equals(HighLight.class)))
                            .forEach(tile -> tile.add(new PermamentHighLigth(grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));*/
                }



        if (isGameWon()) {
            JOptionPane.showMessageDialog(null, "You won!!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }/* else if (isGameFailed()) {
            JOptionPane.showMessageDialog(null, "Game Lost, No more steps!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }*/
        return result;
    }

    public boolean isGameFailed() {
        return getValidSteps(((Tile) actualPawn.getParent()).getCoordinate()).isEmpty();
    }

    @Override
    public boolean isGameWon() {
        return steps.size() >= 8;
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