package exam.logic.games;

import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;
import exam.logic.controllers.PickupMouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.BACKBUTTON;
import static exam.elements.panels.Menu.PAUSEBUTTON;
import static exam.elements.panels.Menu.TIMER;

public class KnightsTour extends AbstractLogic {

    private java.util.List<Pawn> shades;
    private boolean firstStep;
    private boolean paused;

    public KnightsTour() {
        continuousHighLighting = true;
    }

    @Override
    public void initGame() {
        TIMER.restart();
        paused = false;
        grid.removeMouseListener(controller);
        grid.removeMouseMotionListener((MouseMotionListener) controller);
        controller = new BasicMouseController(this);
        grid.addMouseListener(controller);
        shades = new ArrayList<>();
        firstStep = true;
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        Arrays.stream(PAUSEBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);
        BACKBUTTON.addActionListener(e -> {
            if(!shades.isEmpty()) {
                Tile prevTile = ((Tile) shades.get(shades.size() - 1).getParent());
                shades.remove(shades.size() - 1);
                prevTile.removeChild();
                prevTile.setChild(((Tile)actualPawn.getParent()).removeChild());
            } else if(!firstStep && shades.isEmpty() && actualPawn != null) {
                ((Tile)actualPawn.getParent()).removeChild();
                firstStep = true;

                grid.removeMouseListener(controller);
                grid.removeMouseMotionListener((MouseMotionListener) controller);
                controller = new BasicMouseController(this);
                grid.addMouseListener(controller);
            }
            grid.revalidate();
            grid.repaint();
        });

    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = true;
        if(firstStep) {
            Pawn pawn = new Pawn(Color.black, -1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels());
            pawn.promote();
            setActualPawn(pawn);
            from.setChild(pawn);
            grid.removeMouseListener(controller);
            grid.removeMouseMotionListener((MouseMotionListener) controller);
            controller = new PickupMouseController(this);
            grid.addMouseListener(controller);
            grid.addMouseMotionListener((MouseMotionListener) controller);
        } else {
            if(to instanceof Tile && !to.gotChild() && validSteps.contains(to)) {
                Pawn shade = new Pawn(Color.DARK_GRAY, 1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels());
                shade.demote();
                shades.add(shade);
                from.removeChild();
                from.setChild(shade);
                to.setChild(actualPawn);
            } else {
                from.setChild(from.removeChild());
                result = false;
            }
        }
        firstStep = false;
        continuousHighLighting = true;
        grid.revalidate();
        grid.repaint();

        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game won!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        } else if(isGameFailed()) {
            JOptionPane.showMessageDialog(null, "Game Lost, No more steps!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return result;
    }

    public boolean isGameFailed() {
        return !firstStep && getValidSteps(((Tile) actualPawn.getParent()).getCoordinate()).isEmpty();
    }

    @Override
    public boolean isGameWon() {
        return shades.size() == (grid.getGridWidthByTiles() * grid.getGridHeightByTiles()) - 1;
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if (coordinate != null && tile.gotChild() && tile.getChild() instanceof Pawn && ((Pawn)tile.getChild()).getPlayer() == -1) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if (HIGHLIGHTING) {
            highlight();
        }
    }

    @Override
    public java.util.List<Coordinate> getValidSteps(Coordinate coordinate) {
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        Coordinate actualCoordinate = coordinate;
        actualCoordinate = actualCoordinate.stepInDirection(Directions.UP);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.UPRIGHT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.LEFT);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.LEFT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.DOWNLEFT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.DOWN);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.DOWN);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.DOWNRIGHT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.RIGHT);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.RIGHT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.UPRIGHT);
        coordinates.add(actualCoordinate);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.UP);
        actualCoordinate = actualCoordinate.stepInDirection(Directions.UP);
        coordinates.add(actualCoordinate);
        return coordinates.stream()
                .filter(coord -> tileMap.containsKey(coord))
                .filter(coord -> !tileMap.get(coord).gotChild()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Knight's Tour";
    }
}