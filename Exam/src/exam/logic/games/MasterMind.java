package exam.logic.games;

import exam.elements.tiles.*;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.config.Utilities.getColumnsFromGrid;
import static exam.config.Utilities.transpose;
import static exam.elements.panels.Menu.DIFFSELECTOR;
import static exam.elements.panels.Menu.HINTBUTTON;
import static exam.elements.panels.Menu.PAUSEBUTTON;

public class MasterMind extends AbstractLogic {

    private List<Color> solution;
    private List<List<Tile>> tiles;
    private List<Color> allColors;
    private List<Color> colors;

    private int difficulty;
    private int actualRow;
    private int correctColors;
    private int correctPositions;

    public MasterMind() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
    }

    @Override
    public void initGame() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        partition(1);
        solution = new ArrayList<>();
        allColors = new ArrayList<>();
        colors = new ArrayList<>();
        actualRow = 0;
        correctColors = 0;
        correctPositions = 0;
        Arrays.stream(HINTBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        tiles = transpose(getColumnsFromGrid(grid, 0, grid.getGridWidthByTiles() - 2));
        allColors.add(Color.red);
        allColors.add(Color.blue);
        allColors.add(Color.yellow);
        allColors.add(Color.green);
        allColors.add(Color.white);
        allColors.add(Color.black);
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);
        if(DIFFSELECTOR.getText().chars().allMatch(Character::isDigit)
                && Integer.parseInt(DIFFSELECTOR.getText()) > 0
                && Integer.parseInt(DIFFSELECTOR.getText()) < 7) {
            difficulty = Integer.parseInt(DIFFSELECTOR.getText());
        } else {
            difficulty = allColors.size();
        }
        colors = allColors.subList(0, difficulty);
        solution = new ArrayList<>();
        for (int i = 0; i < grid.getGridWidthByTiles() - 1; i++) {
            solution.add(colors.get(new Random().nextInt(colors.size())));
        }
        rightColumn.forEach(tile -> tile.setChild(new StatusTile(grid.getTileSize())));
        tiles.forEach(row -> row.forEach(tile -> {
            tile.setChild(new ColorTile(colors, grid.getTileSize()));
        }));
        activateRow(actualRow);
        HINTBUTTON.addActionListener(e -> {
            tiles = transpose(getColumnsFromGrid(grid, 0, grid.getGridWidthByTiles() - 2));
            List<Color> rowColors = getRow(tiles, actualRow)
                    .stream()
                    .map(tile -> ((ColorTile) tile.getChild()).getActualColor())
                    .collect(Collectors.toList());
            correctColors = 0;
            correctPositions = 0;
            List<Color> tempSolutions = new ArrayList<>(solution);
            for (int i = 0; i < rowColors.size(); i++) {
                if (rowColors.get(i).equals(solution.get(i))) {
                    correctPositions++;
                }
                if(tempSolutions.contains(rowColors.get(i))) {
                    tempSolutions.remove(rowColors.get(i));
                    correctColors++;
                }
            }
            ((StatusTile) rightColumn.get(actualRow).getChild()).setCorrectColorsAndPositions(correctColors, correctPositions);
            if(isGameWon()) {
                JOptionPane.showMessageDialog(null, "You won at the round: " + actualRow);
                JPanel gp = (JPanel) grid.getParent();
                gp.removeAll();
                gp.revalidate();
                gp.repaint();
                for (ActionListener actionListener : HINTBUTTON.getActionListeners()) {
                    HINTBUTTON.removeActionListener(actionListener);
                }
            }
            deactivateRow(actualRow);
            actualRow++;
            activateRow(actualRow);
            if(actualRow >= grid.getGridHeightByTiles()) {
                JOptionPane.showMessageDialog(null, "You have lost!");
                JPanel gp = (JPanel) grid.getParent();
                gp.removeAll();
                gp.revalidate();
                gp.repaint();
                for (ActionListener actionListener : HINTBUTTON.getActionListeners()) {
                    HINTBUTTON.removeActionListener(actionListener);
                }
            }

        });
    }

    private void activateRow(int actualRow) {
        getRow(tiles, actualRow).stream().map(tile -> ((ColorTile)tile.getChild())).forEach(ColorTile::activate);
        grid.revalidate();
        grid.repaint();
    }

    private void deactivateRow(int actualRow) {
        getRow(tiles, actualRow).stream().map(tile -> ((ColorTile)tile.getChild())).forEach(ColorTile::deactivate);
        grid.revalidate();
        grid.repaint();
    }

    private List<Tile> getRow(List<List<Tile>> tiles, int n) {
        if(n < 0 || n > grid.getGridHeightByTiles()) throw new IndexOutOfBoundsException();
        return tiles.stream()
                .flatMap(Collection::stream)
                .filter(tile -> tile.getCoordinate().getX() == n)
                .collect(Collectors.toList());
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        if(((ColorTile)from.getChild()).isActivated()) {
            ((ColorTile)from.getChild()).nextColor();
        }
        return true;
    }

    @Override
    public boolean isGameWon() {
        return correctColors == solution.size() && correctPositions == solution.size();
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if(coordinate != null && tile.getChild() instanceof ColorTile /*&& ((ColorTile) tile.getChild()).isActivated()*/) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) { highlight();}
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        return coordinates;
    }

    @Override
    public String toString() {
        return "MasterMind";
    }
}