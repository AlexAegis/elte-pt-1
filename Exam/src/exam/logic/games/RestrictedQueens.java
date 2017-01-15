package exam.logic.games;

import exam.elements.tiles.*;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.utilities.MatrixTools;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.BACKBUTTON;

public class RestrictedQueens extends Queens {

    private int activeColumn;
    public RestrictedQueens() {
        super();
        activeColumn = 1;
    }

    @Override
    public void initGame() {
        super.initGame();
        activeColumn = 1;
        activateColumn(activeColumn);
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        BACKBUTTON.addActionListener(e -> {
            if(!steps.isEmpty()) {
                Tile prevTile = ((Tile) steps.get(steps.size() - 1).getParent());
                steps.remove(steps.size() - 1);
                prevTile.removeChild();
                deactivateColumn(activeColumn);
                if(activeColumn > 0) {
                    activeColumn--;
                    activateColumn(activeColumn);
                }
            }
            grid.revalidate();
            grid.repaint();
        });
    }

    private void activateColumn(int i) {
        MatrixTools.getColumnFromMatrix(innerTiles, i - 1).forEach(tile -> tile.add(new PermamentHighLigth(grid.getTileSize()).switchToBase()));
        grid.revalidate();
        grid.repaint();
    }

    private void deactivateColumn(int i) {
        MatrixTools.getColumnFromMatrix(innerTiles, i - 1)
                .forEach(tile -> Arrays.stream(tile.getComponents())
                        .filter(component -> component.getClass().equals(PermamentHighLigth.class))
                        .map(component -> (PermamentHighLigth) component)
                        .forEach(HighLight::takeOff));
        grid.revalidate();
        grid.repaint();
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = false;
        if(firstStep) firstStep = false;
        if (validSteps.stream()
                .flatMap(tile -> Stream.of(tile.getComponents()))
                .filter(component -> component.getClass().equals(HighLight.class))
                .map(component -> (HighLight)component)
                .noneMatch(highLight -> highLight.getActualColors().equals(HighLight.warmColors))
                && MatrixTools.getColumnFromMatrix(innerTiles, activeColumn - 1).contains(from)) {
                    Pawn pawn = new Pawn(Color.black, -1, grid.getTileSize());
                    pawn.promote();
                    setActualPawn(pawn);
                    from.setChild(pawn);
                    steps.add(pawn);
                    result = true;
                    deactivateColumn(activeColumn);
                    if(activeColumn < grid.getGridWidthByTiles()) {
                        activeColumn++;
                        activateColumn(activeColumn);
                    }
                }
        grid.revalidate();
        grid.repaint();
        if (isGameWon()) {
            JOptionPane.showMessageDialog(null, "You won!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        } else if(isGameLost()) {
            JOptionPane.showMessageDialog(null, "You have lost.");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return result;
    }

    @Override
    public boolean isGameWon() {
        return grid.getTiles()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(Tile::gotChild)
                .collect(Collectors.toList()).size() == Math.min(grid.getGridWidthByTiles(), grid.getGridHeightByPixels());
    }

    private boolean isGameLost() {
        return super.isGameWon();
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if (coordinate != null) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if (HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                if(validStep.gotChild()) {
                    validStep.add(new HighLight(grid.getTileSize()).switchToWarm());
                } else {
                    validStep.add(new HighLight(grid.getTileSize()));
                }
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        for(Directions direction : validDirections) {
            Coordinate current = coordinate.stepInDirection(direction);
            while(tileMap.containsKey(current)) {
                coordinates.add(current);
                current = current.stepInDirection(direction);
            }
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return "Restricted Queens";
    }
}