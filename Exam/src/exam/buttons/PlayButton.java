package exam.buttons;

import exam.config.FieldSizes;
import exam.config.GameModes;
import exam.panels.ContentPane;
import exam.panels.Grid;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.DEFAULT_MAX_RNG;
import static exam.config.Config.DEFAULT_MIN_RNG;
import static exam.panels.Menu.*;

public class PlayButton extends JButton {

    private String name = "Play";

    public PlayButton() {
        setText(name);
        setPreferredSize(new Dimension(80, 40));
        addActionListener(e -> {
            int min = DEFAULT_MIN_RNG;
            int max = DEFAULT_MAX_RNG;
            try {
                min = Integer.valueOf(MINRANGESELECTOR.getText());
                max = Integer.valueOf(MAXRANGESELECTOR.getText());
            } catch (NumberFormatException ignored) {

            } finally {
                ContentPane.GAME.removeAll();
                ContentPane.GAME.add(new Grid((FieldSizes) SIZESELECTOR.getSelectedItem(),
                        (GameModes) GAMEMODESELECTOR.getSelectedItem(), min, max));
                MINRANGESELECTOR.setText(Integer.toString(DEFAULT_MIN_RNG));
                MAXRANGESELECTOR.setText(Integer.toString(DEFAULT_MAX_RNG));
                ContentPane.GAME.revalidate();
                ContentPane.GAME.repaint();
            }
        });
    }
}