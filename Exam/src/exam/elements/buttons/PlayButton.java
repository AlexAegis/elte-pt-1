package exam.elements.buttons;

import exam.config.FieldSizes;
import exam.config.GameModes;
import exam.elements.panels.ContentPane;
import exam.elements.panels.Grid;

import javax.swing.*;
import java.awt.*;

import static exam.Main.GAME_WINDOW;
import static exam.config.Config.DEFAULT_MAX_RNG;
import static exam.config.Config.DEFAULT_MIN_RNG;
import static exam.config.Config.DEFAULT_MODIFIER_VALUE;
import static exam.elements.panels.Menu.*;

public class PlayButton extends JButton {

    public PlayButton() {
        setText("Play");
        setPreferredSize(new Dimension(80, 40));
        addActionListener(e -> {
            int min = DEFAULT_MIN_RNG;
            int max = DEFAULT_MAX_RNG;
            int mod = DEFAULT_MODIFIER_VALUE;
            try {
                min = Integer.valueOf(MINRNGSELECTOR.getText());
                max = Integer.valueOf(MAXRNGSELECTOR.getText());
                mod = Integer.valueOf(MODIFIERSELECTOR.getText());
            } catch (NumberFormatException ignored) {
            } finally {
                GameModes gameMode = ((GameModes) GAMEMODESELECTOR.getSelectedItem());
                Grid grid = new Grid(
                        (FieldSizes) SIZESELECTOR.getSelectedItem(),
                        gameMode,
                        min,
                        max,
                        mod,
                        CHECKBOXPANEL.getSelectedDirections());
                GAME_WINDOW.setTitle(GAMEMODESELECTOR.getSelectedItem().toString());
                ContentPane.GAME.removeAll();
                ContentPane.GAME.add(grid);
                TIMER.reset();
                STEPCOUNTER.reset();
                ContentPane.GAME.revalidate();
                ContentPane.GAME.repaint();
            }
        });
    }
}