package exam.buttons;

import exam.config.FieldSizes;
import exam.config.GameModes;
import exam.panels.ContentPane;
import exam.panels.Grid;

import javax.swing.*;
import java.awt.*;

import static exam.panels.Menu.GAMEMODESELECTOR;
import static exam.panels.Menu.SIZESELECTOR;

public class PlayButton extends JButton {

    private String name = "Play";

    public PlayButton() {
        setText(name);
        setPreferredSize(new Dimension(80, 40));
        addActionListener(e -> {
            ContentPane.GAME.removeAll();
            ContentPane.GAME.add(new Grid((FieldSizes) SIZESELECTOR.getSelectedItem(), (GameModes) GAMEMODESELECTOR.getSelectedItem()));
            ContentPane.GAME.revalidate();
            ContentPane.GAME.repaint();
        });
    }
}