package exam.logic.games;

import exam.config.Utilities;
import exam.elements.tiles.*;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.BACKBUTTON;
import static exam.elements.panels.Menu.DIFFSELECTOR;

public class RubikTable extends AbstractLogic {
    private List<Rotator> history;
    private List<Color> allColors;
    private List<Color> colors;
    int diff;

    public RubikTable() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        allColors = new ArrayList<>();
        allColors.add(Color.red);
        allColors.add(Color.blue);
        allColors.add(Color.yellow);
        allColors.add(Color.green);
        allColors.add(Color.white);
        allColors.add(Color.black);
    }

    @Override
    public void initGame() {
        history = new ArrayList<>();
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> BACKBUTTON.removeActionListener(actionListener));
        partition(1);
        upperButtons.forEach(tile -> tile.setChild(new Rotator(Directions.DOWN, grid.getTileSize())));
        lowerButtons.forEach(tile -> tile.setChild(new Rotator(Directions.UP, grid.getTileSize())));
        leftButtons.forEach(tile -> tile.setChild(new Rotator(Directions.RIGHT, grid.getTileSize())));
        rightButtons.forEach(tile -> tile.setChild(new Rotator(Directions.LEFT, grid.getTileSize())));
        final int[] i = {0};
        if(DIFFSELECTOR.getText().chars().allMatch(Character::isDigit)
                && Integer.parseInt(DIFFSELECTOR.getText()) >= 2
                && Integer.parseInt(DIFFSELECTOR.getText()) <= allColors.size()) {
            diff = Integer.parseInt(DIFFSELECTOR.getText());
        } else if(DIFFSELECTOR.getText().chars().allMatch(Character::isDigit)
                && Integer.parseInt(DIFFSELECTOR.getText()) > allColors.size()) {
            diff = allColors.size();
        } else {
            diff = 4;
        }
        colors = allColors.subList(0, diff);
        innerTiles.forEach(row -> {
            Color rowColor = colors.get(i[0] % colors.size());
            i[0]++;
            row.forEach(tile -> tile.setChild(new ColorTile(rowColor, grid.getTileSize()).activate()));
        });
        for (List<Tile> column : Utilities.transpose(innerTiles)) {
            rotateChild(column, (int) (Math.random() * column.size()));
        }
        for (List<Tile> row : innerTiles) {
            rotateChild(row, (int) (Math.random() * row.size()));
        }
        BACKBUTTON.addActionListener(e -> {
            if(!history.isEmpty()) {
                Rotator rotator = history.get(history.size() - 1);
                history.remove(history.size() - 1);
                if(rotator.getDirection().equals(Directions.DOWN)) {
                    Rotator rotator1 = ((Rotator)lowerButtons.get(getTileLocation((Tile)rotator.getParent()).getY() - 1).getChild());
                    rotator1.mouseClicked(new MouseEvent(rotator1, 1, 1, 1, 1, 1, 1, false));
                } else if(rotator.getDirection().equals(Directions.UP)) {
                    Rotator rotator1 = ((Rotator)upperButtons.get(getTileLocation((Tile)rotator.getParent()).getY() - 1).getChild());
                    rotator1.mouseClicked(new MouseEvent(rotator1, 1, 1, 1, 1, 1, 1, false));
                } else if(rotator.getDirection().equals(Directions.LEFT)) {
                    Rotator rotator1 = ((Rotator)leftButtons.get(getTileLocation((Tile)rotator.getParent()).getX() - 1).getChild());
                    rotator1.mouseClicked(new MouseEvent(rotator1, 1, 1, 1, 1, 1, 1, false));
                } else if(rotator.getDirection().equals(Directions.RIGHT)) {
                    Rotator rotator1 = ((Rotator)rightButtons.get(getTileLocation((Tile)rotator.getParent()).getX() - 1).getChild());
                    rotator1.mouseClicked(new MouseEvent(rotator1, 1, 1, 1, 1, 1, 1, false));
                }
                history.remove(history.size() - 1);
            }
            grid.revalidate();
            grid.repaint();
        });
        grid.revalidate();
        grid.repaint();
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {
        boolean result = false;
        if(from.getChild() instanceof Rotator) {
            switch(((Rotator) from.getChild()).getDirection()) {
                case DOWN:
                    rotateChild(Utilities.getColumnFromMatrix(innerTiles, from.getCoordinate().getY() - 1));
                    break;
                case UP:
                    rotateChild(Utilities.reverse(Utilities.getColumnFromMatrix(innerTiles, from.getCoordinate().getY() - 1)));
                    break;
                case RIGHT:
                    rotateChild(Utilities.getRowFromMatrix(innerTiles, from.getCoordinate().getX() - 1));
                    break;
                case LEFT:
                    rotateChild(Utilities.reverse(Utilities.getRowFromMatrix(innerTiles, from.getCoordinate().getX() - 1)));
                    break;
                default:
                    break;
            }
            result = true;
            history.add((Rotator) from.getChild());
        }
        grid.revalidate();
        grid.repaint();

        if (isGameWon()) {
            if(isRowWon()) {
                JOptionPane.showMessageDialog(null, "You completed the rows!!");
            } else {
                JOptionPane.showMessageDialog(null, "You completed the columns!!");
            }
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return result;
    }

    private void rotateChild(List<Tile> tiles) {
        Component current = tiles.get(tiles.size() - 1).removeChild();
        for (Tile tile : tiles) {
            Component temp = current;
            if (tile.gotChild()) current = tile.removeChild();
            tile.setChild(temp);
        }
    }

    private void rotateChild(List<Tile> tiles, int times) {
        for (int i = 0; i < times; i++) {
            rotateChild(tiles);
        }
    }

    @Override
    public boolean isGameWon() {
        return isRowWon() || isColumnWon();
    }

    public boolean isRowWon() {
        boolean result = true;
        for (List<Tile> row : innerTiles) {
            Color rowColor = ((ColorTile)row.get(0).getChild()).getActualColor();
            result &= row.stream().map(tile -> ((ColorTile)tile.getChild())).allMatch(colorTile -> colorTile.getActualColor().equals(rowColor));
        }
        return result;
    }

    public boolean isColumnWon() {
        boolean result = true;
        for (List<Tile> row : Utilities.transpose(innerTiles)) {
            Color rowColor = ((ColorTile)row.get(0).getChild()).getActualColor();
            result &= row.stream().map(tile -> ((ColorTile)tile.getChild())).allMatch(colorTile -> colorTile.getActualColor().equals(rowColor));
        }
        return result;
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if(coordinate != null) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileSize()).switchToWeak(), 0);
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public java.util.List<Coordinate> getValidSteps(Coordinate coordinate) {
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        if (tileMap.get(coordinate).gotChild() && tileMap.get(coordinate).getChild() instanceof Rotator) {
            switch(((Rotator) tileMap.get(coordinate).getChild()).getDirection()) {
                case DOWN:
                    coordinates = Utilities.getColumnFromMatrix(innerTiles, coordinate.getY() - 1).stream().map(Tile::getCoordinate).collect(Collectors.toList());
                    break;
                case UP:
                    coordinates = Utilities.reverse(Utilities.getColumnFromMatrix(innerTiles, coordinate.getY() - 1)).stream().map(Tile::getCoordinate).collect(Collectors.toList());
                    break;
                case RIGHT:
                    coordinates = Utilities.getRowFromMatrix(innerTiles, coordinate.getX() - 1).stream().map(Tile::getCoordinate).collect(Collectors.toList());
                    break;
                case LEFT:
                    coordinates = Utilities.reverse(Utilities.getRowFromMatrix(innerTiles, coordinate.getX() - 1)).stream().map(Tile::getCoordinate).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return "Rubik Table";
    }
}