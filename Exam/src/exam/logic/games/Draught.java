package exam.logic.games;

import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.PickupMouseController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Draught extends AbstractLogic {

    private Tile aboveTarget = null;

    public Draught() {
        continuousHighLighting = true;
        controller = new PickupMouseController(this);
    }

    @Override
    public void initGame() {
        int lines = 2;
        if (grid.getGridWidthByTiles() >= 8) {
            lines = 3;
        }
        if (grid.getGridWidthByTiles() >= 10) {
            lines = 4;
        }
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < grid.getGridWidthByTiles(); j++) {
                if (((i + j) % 2) == 1) {
                    Tile panel = (Tile) grid.getComponent((i * grid.getGridWidthByTiles()) + j);
                    panel.add(new Pawn(p1Color, -1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
                }
            }
        }

        for (int i = grid.getGridHeightByTiles() - lines; i < grid.getGridHeightByTiles() ; i++) {
            for (int j = 0; j < grid.getGridWidthByTiles(); j++) {
                if (((i + j) % 2) == 1) {
                    Tile panel = (Tile) grid.getComponent((i * grid.getGridWidthByTiles()) + j);
                    panel.add(new Pawn(p2Color, 1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
                }
            }
        }

    }

    @Override
    public void setValidSteps(Tile t) {
        Coordinate location = findPawn(actualPawn);
        Arrays.stream(Directions.values()).forEach(direction -> {
            boolean fw = false;
            if (actualPlayer == -1) {
                fw = direction.isForward();
            } else {
                fw = direction.turnVertical().isForward();
            }
            if ((fw || actualPawn.isPromoted()) && direction.isDiagonal()) {
                try {
                    Tile tile = (Tile) grid.getComponentAt(grid.getTileWidthByPixels() * location.getX() + (direction.getX() * grid.getTileWidthByPixels()), grid.getTileHeightByPixels() * location.getY() + (direction.getY() * grid.getTileHeightByPixels()));
                    Tile tileAbove = (Tile) grid.getComponentAt(grid.getTileWidthByPixels() * location.getX() + (direction.getX() * 2 * grid.getTileWidthByPixels()), grid.getTileHeightByPixels() * location.getY() + (direction.getY() * 2 * grid.getTileHeightByPixels()));
                    if (tile != null) {
                        if (tile.getComponents().length == 0) {
                            validSteps.add(tile);
                        } else if (tile.getComponents().length == 1
                                && tile.getComponent(0) instanceof Pawn
                                && ((Pawn) tile.getComponent(0)).getPlayer() != actualPlayer) {
                            if (tileAbove != null && tileAbove.getComponents().length == 0) {
                                validSteps.add(tileAbove);
                                aboveTarget = tileAbove;
                                setTarget((Pawn) tile.getComponent(0));
                            }
                        }
                    }
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        });
        validSteps.forEach(v ->
                v.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return null;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {/*
        Container parent = to.getParent();
        if (target != null && to.getParent().equals(aboveTarget)) {
            target.takeOff();
        } else if (to instanceof HighLight) {
            switchActualPlayer();
        } else {
            parent = (Container) from;
        }
        parent.add(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        if (isReachedEnd()) {
            actualPawn.promote();
        }
        if (isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + actualPawn.toString());
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }
        clearActualPawn();
        clearTarget();
        aboveTarget = null;*/
        return true;
    }


    @Override
    public boolean isGameWon() {
        return Arrays.stream(grid.getComponents()).filter(component -> ((Tile) component).getComponents().length > 0)
                .map(component -> ((Tile) component).getComponent(0))
                .allMatch(component -> ((Pawn) component).getPlayer() == actualPawn.getPlayer());
    }

    public boolean isReachedEnd() {
        ArrayList<Tile> goal = new ArrayList<>();
        for (int i = 0; i < grid.getGridWidthByTiles(); i++) {
            if (actualPawn.getPlayer() == -1) {
                goal.add((Tile) grid.getComponent(grid.getComponents().length - i - 1));
            } else {
                goal.add((Tile) grid.getComponent(i));
            }
        }
        return goal.stream()
                .anyMatch(tile -> tile.getComponents().length > 0 &&
                        tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == actualPawn.getPlayer());
    }

    @Override
    public String toString() {
        return "Draught";
    }
}