package exam.logic.games;

import exam.Main;
import exam.elements.tiles.*;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.PickupMouseController;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static exam.Window.KEYBOARDCONTROLLER;
import static exam.elements.panels.Menu.*;
import static exam.elements.panels.Menu.BACKBUTTON;

public class Snake extends AbstractLogic {

    private List<Coordinate> body;
    private Pawn head;

    private ColorTile fruit;
    private Color snakeColor;

    private Tile headPosition;

    private Directions prevDir;

    private int timerDelay;

    public Snake() {
        continuousHighLighting = false;
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
    }

    @Override
    public void initGame() {
        timerDelay = 250;
        setTimerDelay(timerDelay);
        timer = new Timer(timerDelay, a -> {
            Coordinate destination = (((Tile)actualPawn.getParent()).getCoordinate().stepInDirection(direction));
            if (tileMap.containsKey(destination)) {
                if(prevDir != null && prevDir.opposite().equals(direction)){
                    direction = prevDir;
                } else {
                    snakeStepTo(destination);
                }
                prevDir = direction;
            } else {
                gameLost();
            }
        });
        timer.start();

        snakeColor = new Color(0,255, 89,255);
        fruit = new ColorTile(Color.red, grid.getTileSize()).activate();
        tileMap.get(new Coordinate(2, 2)).setChild(fruit);
        body = new ArrayList<>();
        Main.GAME_WINDOW.requestFocus();
        partition(0);
        setValidDirections(Directions.DOWN,
                Directions.LEFT,
                Directions.RIGHT,
                Directions.UP);
        Arrays.stream(HINTBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        continuousHighLighting = false;
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);

        head = new CirclePawn(snakeColor, -1, grid.getTileSize());
        headPosition = tileMap.get(new Coordinate(5, 5));
        headPosition.setChild(head);
        setActualPawn(head);

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
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return validDirections.stream()
                .map(coordinate::stepInDirection)
                .filter(coordinate1 -> tileMap.containsKey(coordinate1))
                .filter(coordinate1 -> !tileMap.get(coordinate1).gotChild() || tileMap.get(coordinate1).getChild().equals(fruit))
                .collect(Collectors.toList());
    }

    private void snakeStepTo(Coordinate destination) {
        boolean result = true;
        Tile to = tileMap.get(destination);
        setValidSteps(headPosition);
        if(headPosition.gotChild() && validSteps.contains(to) && !to.gotChild()) {
            Component component = headPosition.removeChild();
            to.setChild(component);
        } else if(headPosition.gotChild() && validSteps.contains(to) && to.gotChild() && to.getChild().equals(fruit)) {
            body.add(headPosition.getCoordinate());
            timerDelay = (int) (timerDelay / 1.05);
            setTimerDelay(timerDelay);
            to.removeChild();
            Component component = headPosition.removeChild();
            to.setChild(component);
            List<Tile> possibleFruitLocations = tileMap.entrySet().stream().map(Map.Entry::getValue).filter(tile -> !tile.gotChild()).collect(Collectors.toList());
            possibleFruitLocations.get(new Random().nextInt(possibleFruitLocations.size())).setChild(fruit);
        } else if(headPosition.gotChild() && (to.gotChild() && body.contains(to.getCoordinate()) || !tileMap.containsKey(to.getCoordinate()))) {
            gameLost();
        } else {
            result = false;
            Component component = headPosition.removeChild();
            headPosition.setChild(component);
        }
        setValidSteps(to);
        if(result) {
            tileMap.entrySet().stream()
                    .map(Map.Entry::getValue)
                    .filter(Tile::gotChild)
                    .filter(tile -> tile.getChild() instanceof ColorTile && !tile.getChild().equals(fruit))
                    .forEach(Tile::removeChild);
            if(!body.isEmpty()) {
                body.remove(0);
                body.add(headPosition.getCoordinate());
            }
            tileMap.forEach((coordinate, tile) -> {
                if(body.contains(coordinate)) {
                    tile.setChild(new ColorTile(snakeColor, grid.getTileSize()).activate());
                }
            });
        }
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "GAME WON!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }

        headPosition = to;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        return true;
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