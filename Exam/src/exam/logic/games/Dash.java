package exam.logic.games;

import exam.config.FieldSizes;
import exam.elements.tiles.HighLight;
import exam.elements.tiles.Pawn;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dash extends AbstractLogic implements GameLogic {

    @Override
    public void initGame() {
        for (int i = 0; i < Math.min(grid.getGridWidthByTiles(), grid.getGridHeightByPixels()) * 2; i++) {
            Pawn piece = new Pawn(p1Color, -1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels());
            Tile panel = (Tile) grid.getComponent(i);
            panel.add(piece);
        }
        for (int i = 0; i < Math.min(grid.getGridWidthByTiles(), grid.getGridHeightByPixels()) * 2; i++) {
            Tile panel = (Tile) grid.getComponent((Math.min(grid.getGridWidthByTiles(), grid.getGridHeightByPixels()) * Math.min(grid.getGridWidthByTiles(), grid.getGridHeightByPixels())) - i - 1);
            panel.add(new Pawn(p2Color, 1, grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
        }
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate location = findPawn(actualPawn);
        if(location != null) {
            try {
                Tile front = (Tile) grid.getComponentAt(grid.getTileWidthByPixels() * location.getX(), grid.getTileHeightByPixels() * location.getY() - grid.getTileWidthByPixels() * actualPlayer);
                if (front != null && !Arrays.stream(front.getComponents()).anyMatch(component -> component instanceof Pawn)) {
                    validSteps.add(front);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

            try {
                Tile left = (Tile) grid.getComponentAt(grid.getTileWidthByPixels() * location.getX() - grid.getTileWidthByPixels(), grid.getTileWidthByPixels() * location.getY() - grid.getTileWidthByPixels() * actualPlayer);
                if (left != null && !Arrays.stream(left.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn) component).getPlayer() == actualPlayer)) {
                    validSteps.add(left);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            try {
                Tile right = (Tile) grid.getComponentAt(grid.getTileWidthByPixels() * location.getX() + grid.getTileWidthByPixels(), grid.getTileWidthByPixels() * location.getY() - grid.getTileWidthByPixels() * actualPlayer);
                if (right != null && !Arrays.stream(right.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn) component).getPlayer() == actualPlayer)) {
                    validSteps.add(right);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            validSteps.forEach(v ->
                    v.add(new HighLight(grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        }
    }

    @Override
    public void evaluateStep(JComponent from, JComponent to) {
        Container parent = to.getParent();
        if (to instanceof Pawn && validSteps.contains(to.getParent())) {
            ((Pawn) to).takeOff();
            switchActualPlayer();
        } else if(to instanceof HighLight) {
            parent = to.getParent();
            switchActualPlayer();
        } else {
            parent = (Container) from;
        }
        parent.add(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + (actualPawn.getPlayer() == 1 ? "Red" : "Blue"));
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
        }
        clearActualPawn();
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