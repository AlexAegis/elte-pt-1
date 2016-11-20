package com.github.alexaegis.logic;

import com.github.alexaegis.tiles.HightLight;
import com.github.alexaegis.tiles.Pawn;
import com.github.alexaegis.tiles.Tile;

import java.util.Arrays;
import java.util.List;

import static com.github.alexaegis.Main.TILE_SIZE;

public class DashChessPawnLogic extends DashLogic implements GameLogic {
    @Override
    public List<Tile> getValidSteps() {
        int[] location = findPawn(actualPawn);
        if(location != null) {
            try {
                Tile front = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0], TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if(front != null && !Arrays.stream(front.getComponents()).anyMatch(component -> component instanceof Pawn)) {
                    validSteps.add(front);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

            try {
                Tile left = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] - TILE_SIZE, TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if(left != null && !Arrays.stream(left.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn)component).getPlayer() == actualPlayer) && left.getComponents().length == 1) {
                    validSteps.add(left);
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            try {
                Tile right = (Tile) actualGamePanel.getComponentAt(TILE_SIZE * location[0] + TILE_SIZE, TILE_SIZE * location[1] - TILE_SIZE * actualPlayer);
                if(right != null && !Arrays.stream(right.getComponents()).anyMatch(component -> component instanceof Pawn && ((Pawn)component).getPlayer() == actualPlayer) && right.getComponents().length == 1) {
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
}