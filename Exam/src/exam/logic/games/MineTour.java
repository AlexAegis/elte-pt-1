package exam.logic.games;

import exam.Main;
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
import java.util.Random;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.*;
import static exam.Window.KEYBOARDCONTROLLER;

public class MineTour extends AbstractLogic {

    private List<Tile> history;
    private List<Coordinate> mines;
    private int difficulty;

    public MineTour() {
        difficulty = 1;
        continuousHighLighting = true;
        //controller = new PickupMouseController(this);
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
    }

    @Override
    public void initGame() {
        mines = new ArrayList<>();

        difficulty = 1;
        Main.GAME_WINDOW.requestFocus();
        partition(0);
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
        Arrays.stream(HINTBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        continuousHighLighting = true;
        history = new ArrayList<>();
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);

        if(DIFFSELECTOR.getText().chars().allMatch(Character::isDigit)
                && Integer.parseInt(DIFFSELECTOR.getText()) > 0
                && Integer.parseInt(DIFFSELECTOR.getText()) < grid.getGridWidthByTiles()) {
            difficulty = Integer.parseInt(DIFFSELECTOR.getText());
        }

        Pawn pawn = new Pawn(Color.black, 1, grid.getTileSize());
        innerTiles.get(0).get(0).setChild(pawn);
        setActualPawn(pawn);
        for (int i = 0; i < difficulty; i++) {
            mines.add(new Coordinate(new Random().nextInt(grid.getGridWidthByTiles() - 1), new Random().nextInt(grid.getGridHeightByTiles() - 1)));
        }
        mines.forEach(System.out::println);
        BACKBUTTON.addActionListener(e -> {
            if(!history.isEmpty()) {
                history.remove(history.size() - 1); // but do something with it before. Note that if you re use a step, that will add the step back to the history so delete it again at the end
            }
            grid.revalidate();
            grid.repaint();
        });
        KEYBOARDCONTROLLER.enable();
        KEYBOARDCONTROLLER.setGameLogic(this);
        grid.revalidate();
        grid.repaint();
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = (tile).getCoordinate();
        if(coordinate != null && tile.gotChild()) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileSize()).switchToWeak());
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
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = true;
        clearValidSteps();
        to.setChild(from.removeChild());
        history.add(to);
        setValidSteps(to);

        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "GAME WON!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        } else if(mines.stream().anyMatch(coordinate -> to.getCoordinate().equals(coordinate))) {
            JOptionPane.showMessageDialog(null, "YOU HAVE BLOWN UP!");
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
        return ((Tile)actualPawn.getParent()).getCoordinate().equals(new Coordinate(grid.getGridWidthByTiles() - 1, grid.getGridHeightByTiles() - 1));
    }

    @Override
    public String toString() {
        return "MineTour";
    }
}