package com.github.alexaegis.logic;

import com.github.alexaegis.panels.GameFieldPanel;
import com.github.alexaegis.tiles.HightLight;
import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public enum GameModes {
    DASH;

    private int actualPlayer;
    private Pawn actualPawn;
    private ArrayList<Tile> validSteps = new ArrayList<>();
    private GameFieldPanel actualGamePanel;

    public void initGame(FieldSizeOptions option) {
        actualPlayer = 1;
        switch(this) {
            case DASH:
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
    }

    public ArrayList<Tile> getValidSteps() {
        switch(this) {
            case DASH:
                boolean foundThePawn = false;
                for (int i = 0; i < GRID_SIZE_DEFAULT / TILE_SIZE && !foundThePawn; i++) {
                    for (int j = 0; j < GRID_SIZE_DEFAULT / TILE_SIZE && !foundThePawn; j++) {
                        foundThePawn = actualGamePanel.getComponentAt(TILE_SIZE * i, TILE_SIZE * j) == actualPawn.getParent();
                        if(foundThePawn) {
                            try {
                                Tile front = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * i, TILE_SIZE * j - TILE_SIZE * actualPlayer);
                                if(front != null && !Arrays.stream(front.getComponents()).anyMatch(component -> component instanceof Pawn)) {
                                    validSteps.add(front);
                                }
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                            }

                            try {
                                Tile left = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * i - TILE_SIZE, TILE_SIZE * j - TILE_SIZE * actualPlayer);
                                if(left != null && !Arrays.stream(left.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn)component).getPlayer() == actualPlayer)) {
                                    validSteps.add(left);
                                }
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                            }
                            try {
                                Tile right = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * i + TILE_SIZE, TILE_SIZE * j - TILE_SIZE * actualPlayer);
                                if(right != null && !Arrays.stream(right.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn)component).getPlayer() == actualPlayer)) {
                                    validSteps.add(right);
                                }
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                            }
                            validSteps.forEach(v ->
                                    v.add(new HightLight()));
                        }
                    }
                }
        }
        return validSteps;
    }

    public void clearValidSteps() {
        validSteps.stream().flatMap(valid -> Stream.of(valid.getComponents()))
                .filter(component -> component instanceof HightLight)
                .forEach(highLight -> highLight.getParent().remove(highLight));
        validSteps.clear();
    }

    public int getActualPlayer() {
        return actualPlayer;
    }

    public void switchActualPlayer() {
        actualPlayer = 0 - actualPlayer;
    }

    public void setActualPawn(Pawn pawn) {
        actualPawn = pawn;
        getValidSteps();
    }

    public boolean currentPlayersPawn(Pawn pawn) {
        return pawn.getPlayer() == getActualPlayer();
    }

    public Pawn getActualPawn() {
        return actualPawn;
    }

    public void setActualGamePanel(GameFieldPanel actualGamePanel) {
        this.actualGamePanel = actualGamePanel;
    }

    public void clearActualPawn() {
        actualPawn = null;
    }

    public void evaluateStep(Component destination, Component original) {
        Container parent = destination.getParent();
        switch (this) {
            case DASH:
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
                break;
        }
        if(isGameWon()) {
            System.out.println("GAME OVER!");
            System.out.println("WON BY: " + (actualPawn.getPlayer() == -1 ? "red" : "blue"));

        }
        clearActualPawn();
        clearValidSteps();
    }

    public boolean isGameWon() {
        switch(this) {
            case DASH:
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
            default:
                return false;

        }
    }
}