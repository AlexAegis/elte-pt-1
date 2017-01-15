package exam.elements.buttons;

import exam.Main;
import exam.elements.panels.Grid;

import javax.swing.*;

import static exam.elements.panels.Menu.TIMER;

public class PauseButton extends JButton {

    private boolean paused = false;
    private Grid actualGrid;

    public PauseButton() {
        setText("Pause");
        setVisible(true);
        addActionListener(e -> {
            Main.GAME_WINDOW.requestFocus();
            if(actualGrid != null) {
                if(paused) {
                    actualGrid.setVisible(true);
                    TIMER.resume();
                    paused = false;
                } else {
                    actualGrid.setVisible(false);
                    TIMER.pause();
                    paused = true;
                }
            }
        });
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void setActualGrid(Grid actualGrid) {
        this.actualGrid = actualGrid;
    }

    public void reset() {
        if(actualGrid != null) {
            actualGrid.setVisible(true);
            actualGrid = null;
        }
        TIMER.reset();
        this.paused = false;
    }
}