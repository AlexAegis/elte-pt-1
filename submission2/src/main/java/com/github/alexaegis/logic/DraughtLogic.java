package com.github.alexaegis.logic;

import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import java.awt.*;
import java.util.List;

public class DraughtLogic extends AbstractLogic implements GameLogic {

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
        return null;
    }

    @Override
    public void evaluateStep(Component destination, Component original) {

    }

    @Override
    public boolean isGameWon() {
        return false;
    }
}