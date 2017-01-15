package exam.logic.games;

import exam.elements.tiles.HighLight;
import exam.elements.tiles.Tile;
import exam.logic.abstraction.AbstractLogic;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.controllers.BasicMouseController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exam.config.Config.HIGHLIGHTING;
import static exam.elements.panels.Menu.BACKBUTTON;
import static exam.elements.panels.Menu.HINTBUTTON;
import static exam.elements.panels.Menu.PAUSEBUTTON;

public class Empty extends AbstractLogic {

    private List<Tile> history;

    public Empty() {
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
    }

    @Override
    public void initGame() {
        Arrays.stream(HINTBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        Arrays.stream(BACKBUTTON.getActionListeners()).forEach(actionListener -> HINTBUTTON.removeActionListener(actionListener));
        continuousHighLighting = true;
        controller = new BasicMouseController(this);
        setValidDirections(Directions.UP, Directions.UPLEFT, Directions.UPRIGHT);
        partition(0);
        history = new ArrayList<>();
        PAUSEBUTTON.reset();
        PAUSEBUTTON.setActualGrid(grid);
        BACKBUTTON.addActionListener(e -> {
            if(!history.isEmpty()) {
                history.remove(history.size() - 1); // but do something with it before. Note that if you re use a step, that will add the step back to the history so delete it again at the end
            }
            grid.revalidate();
            grid.repaint();
        });
        grid.revalidate();
        grid.repaint();
    }

    @Override
    public void setValidSteps(Tile tile) {
        Coordinate coordinate = tile.getCoordinate();
        if(coordinate != null /*&& ((ColorTile) tile.getChild()).isActivated()*/) {
            validSteps = getValidSteps(coordinate).stream()
                    .map(c -> tileMap.get(c))
                    .collect(Collectors.toList());
        }
        if(HIGHLIGHTING) {
            validSteps.forEach(validStep -> {
                validStep.add(new HighLight(grid.getTileSize()).switchToWarm());
                validStep.revalidate();
                validStep.repaint();
            });
        }
    }

    @Override
    public List<Coordinate> getValidSteps(Coordinate coordinate) {
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinate);
        return coordinates;
    }

    @Override
    public boolean evaluateStep(Tile from, Tile to) {




        if(isGameWon()) {
            JOptionPane.showMessageDialog(null, "GAME OVER!");
            JPanel gp = (JPanel) grid.getParent();
            gp.removeAll();
            gp.revalidate();
            gp.repaint();
        }
        return true;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public String toString() {
        return "Empty";
    }
}