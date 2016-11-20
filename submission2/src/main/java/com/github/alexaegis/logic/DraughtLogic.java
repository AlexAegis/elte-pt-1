package com.github.alexaegis.logic;

import com.github.alexaegis.panels.MenuPanel;
import com.github.alexaegis.tiles.HightLight;
import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public class DraughtLogic extends AbstractLogic implements GameLogic {

    private Tile aboveTarget = null;

    @Override
    public void initGame(FieldSizeOptions option) {
        int lines = 2;
        if(option.getHeight() >= 8) {
            lines = 3;
        }
        if(option.getHeight() >= 10) {
            lines = 4;
        }
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < option.getWidth(); j++) {
                if(((i + j) % 2) == 1) {
                    Tile panel = (Tile) actualGamePanel.getComponent((i * option.getWidth()) + j);
                    panel.add(new Pawn(-1));
                }
            }
        }

        for (int i = option.getHeight() - lines; i < option.getHeight(); i++) {
            for (int j = 0; j < option.getWidth(); j++) {
                if(((i + j) % 2) == 1) {
                    Tile panel = (Tile) actualGamePanel.getComponent((i * option.getWidth()) + j);
                    panel.add(new Pawn(1));
                }
            }
        }

    }

    @Override
    public List<Tile> getValidSteps() {
        int[] location = findPawn(actualPawn);
        Arrays.stream(Directions.values()).forEach(direction -> {
            boolean fw = false;
            if(actualPlayer == -1) {
                fw = direction.isForward();
            } else {
                fw = direction.turnVertical().isForward();
            }
            if((fw && direction.isDiagonal()) || actualPawn.isPromoted()) {
                try {
                    Tile tile = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] + (direction.getX() * TILE_SIZE), TILE_SIZE * location[1] + (direction.getY() * TILE_SIZE));
                    Tile tileAbove = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] + (direction.getX() * 2 * TILE_SIZE), TILE_SIZE * location[1] + (direction.getY() * 2 * TILE_SIZE));
                    if (tile != null) {
                        if(tile.getComponents().length == 0) {
                            validSteps.add(tile);
                        } else if(tile.getComponents().length == 1
                                && tile.getComponent(0) instanceof Pawn
                                && ((Pawn)tile.getComponent(0)).getPlayer() != actualPlayer) {
                            if(tileAbove != null && tileAbove.getComponents().length == 0) {
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
                v.add(new HightLight()));
        return validSteps;
    }

    @Override
    public void evaluateStep(Component destination, Component original) {
        Container parent = destination.getParent();
        if (target != null && destination.getParent().equals(aboveTarget)) {
            target.takeOff();
        } else if(destination instanceof HightLight) {
            switchActualPlayer();
        } else {
            parent = (Container) original;
        }
        parent.add(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        if(isReachedEnd()) {
            actualPawn.promote();
        }
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + (actualPawn.getPlayer() == 1 ? "Red" : "Blue"));
            JPanel gp = (JPanel) actualGamePanel.getParent().getParent();
            gp.removeAll();
            gp.add(new MenuPanel());
            gp.revalidate();
            gp.repaint();
        }
        clearActualPawn();
        clearTarget();
        aboveTarget = null;
    }


    @Override
    public boolean isGameWon() {
        return Arrays.stream(actualGamePanel.getComponents()).filter(component -> ((Tile)component).getComponents().length > 0)
                .map(component -> ((Tile)component).getComponent(0))
                .allMatch(component -> ((Pawn)component).getPlayer() == actualPawn.getPlayer());
    }

    public boolean isReachedEnd() {
        ArrayList<Tile> goal1 = new ArrayList<>(); // Blue dest
        ArrayList<Tile> goal2 = new ArrayList<>(); // Red dest
        for (int i = 0; i < GRID_SIZE_DEFAULT / TILE_SIZE; i++) {
            goal1.add((Tile) actualGamePanel.getComponent(actualGamePanel.getComponents().length - i - 1));
            goal2.add((Tile) actualGamePanel.getComponent(i));
        }
        return goal1.stream()
                .anyMatch(tile -> tile.getComponents().length > 0 &&
                        tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == -1) ||
                goal2.stream().anyMatch(tile -> tile.getComponents().length > 0 && tile.getComponent(0) instanceof Pawn && ((Pawn) tile.getComponent(0)).getPlayer() == 1);
    }
}