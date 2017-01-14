package exam.logic.games;

import exam.elements.tiles.*;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Utilities.getColumnFromGrid;
import static exam.config.Utilities.getColumnsFromGrid;
import static exam.elements.panels.Menu.DIFFSELECTOR;
import static exam.elements.panels.Menu.HINTBUTTON;

public class MasterMind extends AbstractLogic {

    private List<Color> solution = new ArrayList<>();
    private List<List<Tile>> tiles;
    private List<Tile> hints;
    private List<Color> colors = new ArrayList<>();

    private int difficulty;
    private int actualRow = 0;

    private int correctColors = 0;
    private int correctPositions = 0;

    public MasterMind() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
    }

    @Override
    public void initGame() {
        tiles = getColumnsFromGrid(grid, 0, grid.getGridWidthByTiles() - 2);
        hints = getColumnFromGrid(grid, grid.getGridWidthByTiles() - 1);

        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.yellow);
        colors.add(Color.green);
        colors.add(Color.white);
        colors.add(Color.black);
        if(DIFFSELECTOR.getText().chars().allMatch(Character::isDigit)) {
            difficulty = Integer.parseInt(DIFFSELECTOR.getText());
        } else {
            difficulty = colors.size();
        }
        colors = colors.subList(0, difficulty);

        solution = new ArrayList<>(colors);
        Collections.rotate(solution, new Random().nextInt(solution.size()));
        solution.forEach(System.out::println);

        hints.forEach(tile -> tile.setChild(new StatusTile(grid.getTileWidthByPixels(), grid.getTileHeightByPixels())));
        tiles.forEach(row -> row.forEach(tile -> {
            tile.setChild(new ColorTile(colors, grid.getTileWidthByPixels(), grid.getTileHeightByPixels()));
        }));
        activateRow(actualRow);


        HINTBUTTON.addActionListener(e -> {
            solution.forEach(System.out::println);
            List<Color> rowColors = getRow(tiles, actualRow)
                    .stream()
                    .map(tile -> ((ColorTile) tile.getChild()).getActualColor())
                    .collect(Collectors.toList());
            System.out.println(rowColors);

            System.out.println(rowColors.size());
            System.out.println(solution.size());

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
            ((StatusTile) hints.get(actualRow).getChild()).setCorrectColorsAndPositions(correctColors, correctPositions);
            if(isGameWon()) {
                JOptionPane.showMessageDialog(null, "You won at the: " + actualRow + " round!");
                JPanel gp = (JPanel) grid.getParent();
                gp.removeAll();
            }

            deactivateRow(actualRow);
            actualRow++;
            activateRow(actualRow);

        });
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
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        return null;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        System.out.println(from.toString());
        ((ColorTile)from.getChild()).nextColor();
        return true;//if activerow
    }

    @Override
    public boolean isGameWon() {
        return correctColors == difficulty && correctPositions == difficulty;
    }

    @Override
    public String toString() {
        return "MasterMind";
    }

    public void activateRow(int actualRow) {
        getRow(tiles, actualRow).stream().map(tile -> ((ColorTile)tile.getChild())).forEach(ColorTile::activate);
        grid.revalidate();
        grid.repaint();
    }
}
