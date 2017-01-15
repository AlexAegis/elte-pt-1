package exam.logic.games;

import exam.Main;
import exam.elements.tiles.ColorTile;
import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.PickupMouseController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exam.Window.KEYBOARDCONTROLLER;
import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.*;
import static exam.elements.panels.Menu.BACKBUTTON;

public class Snake extends AbstractLogic {

    private List<Pawn> body;
    private Pawn head;
    private Directions startingDirection = Directions.RIGHT;

    public Snake() {
        continuousHighLighting = true;
        controller = new PickupMouseController(this);
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
    }

    @Override
    public void initGame() {
        body = new ArrayList<>();
        Main.GAME_WINDOW.requestFocus();
        partition(0);
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
        Arrays.stream(HINTBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        continuousHighLighting = true;
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);

        head = new Pawn(Color.black, -1, grid.getTileSize());

        tileMap.get(new Coordinate(5, 5)).setChild(head);
        setActualPawn(head);
/*
        BACKBUTTON.addActionListener(e -> {
            if(!history.isEmpty()) {
                evaluateStep((Tile)actualPawn.getParent(), history.get(history.size() - 1));
                history.remove(history.size() - 1); // but do something with it before. Note that if you re use a step, that will add the step back to the history so delete it again at the end
                history.remove(history.size() - 1); // but do something with it before. Note that if you re use a step, that will add the step back to the history so delete it again at the end
            }
            grid.revalidate();
            grid.repaint();
        });*/
        KEYBOARDCONTROLLER.enable();
        KEYBOARDCONTROLLER.setGameLogic(this);
        grid.revalidate();
        grid.repaint();
    }

    @Override
    public void setValidSteps(Tile tile) {
        clearValidSteps();
        Coordinate coordinate = (tile).getCoordinate();
        if(coordinate != null && tile.gotChild() && tile.getChild().equals(head)) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileSize()).switchToNatural());
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return validDirections.stream()
                .map(coordinate::stepInDirection)
                .filter(coordinate1 -> tileMap.containsKey(coordinate1))
                .filter(coordinate1 -> !tileMap.get(coordinate1).gotChild())
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = true;
        setValidSteps(from);
        if(from.gotChild() && !to.gotChild() && validSteps.contains(to)) {
            Component component = from.removeChild();
            to.setChild(component);
        } else {
            Component component = from.removeChild();
            from.setChild(component);
        }
        setValidSteps(to);



        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "GAME WON!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        grid.revalidate();
        grid.repaint();
        return result;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public String toString() {
        return "Snake";
    }
}