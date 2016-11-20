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

public class DashLogic extends AbstractLogic implements GameLogic {

    @Override
    public void initGame(FieldSizeOptions option) {
        for (int i = 0; i < Math.min(option.getWidth(), option.getHeight()) * 2; i++) {
            Pawn piece = new Pawn(-1);
            Tile panel = (Tile) actualGamePanel.getComponent(i);
            panel.add(piece);
        }
        for (int i = 0; i < Math.min(option.getWidth(), option.getHeight()) * 2; i++) {
            Pawn piece = new Pawn(1);
            Tile panel = (Tile) actualGamePanel.getComponent((Math.min(option.getWidth(), option.getHeight()) * Math.min(option.getWidth(), option.getHeight())) - i - 1);
            panel.add(piece);
        }
    }

    @Override
    public List<Tile> getValidSteps() {
        int[] location = findPawn(actualPawn);
        if(location != null) {
            try {
                Tile front = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0], TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if (front != null && !Arrays.stream(front.getComponents()).anyMatch(component -> component instanceof Pawn)) {
                    validSteps.add(front);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

            try {
                Tile left = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] - TILE_SIZE, TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if (left != null && !Arrays.stream(left.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn) component).getPlayer() == actualPlayer)) {
                    validSteps.add(left);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            try {
                Tile right = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] + TILE_SIZE, TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if (right != null && !Arrays.stream(right.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn) component).getPlayer() == actualPlayer)) {
                    validSteps.add(right);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            validSteps.forEach(v ->
                    v.add(new HightLight()));
        }
        return validSteps;
    }

    @Override
    public void evaluateStep(Component destination, Component original) {
        Container parent = destination.getParent();
        if (destination instanceof Pawn && validSteps.contains(destination.getParent())) {
            parent.remove(0);
            switchActualPlayer();
        } else if(destination instanceof HightLight) {
            parent = destination.getParent();
            switchActualPlayer();
        } else {
            parent = (Container) original;
        }
        parent.add(getActualPawn());
        parent.repaint();
        parent.validate();
        clearValidSteps();
        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "Game over! The winner is: " + (actualPawn.getPlayer() == 1 ? "Red" : "Blue"));
            JPanel gp = (JPanel) actualGamePanel.getParent().getParent();
            gp.removeAll();
            gp.add(new MenuPanel());
            gp.revalidate();
            gp.repaint();
        }
        clearActualPawn();
    }

    @Override
    public boolean isGameWon() {
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