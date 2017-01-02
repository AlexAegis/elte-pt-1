package exam.panels;

import exam.buttons.CloseButton;
import exam.buttons.GameModeSelector;
import exam.buttons.PlayButton;
import exam.buttons.SizeSelector;

import javax.swing.*;
import java.awt.*;

import static exam.panels.Menu.MENU_BG_COLOR;

public class ControlPane extends JPanel {

    private GridBagConstraints gc = new GridBagConstraints();
    public static SizeSelector SIZESELECTOR = new SizeSelector();
    public static GameModeSelector GAMEMODESELECTOR = new GameModeSelector();

    public ControlPane() {
        setLayout(new GridBagLayout());
        setBackground(MENU_BG_COLOR);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weighty = 0.01;
        gc.weightx = 0.01;
        gc.insets = new Insets(10,10,10,10);

        gc.gridx = 0;
        gc.gridy = 0;
        add(new PlayButton(), gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(new CloseButton(), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        add(SIZESELECTOR, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(GAMEMODESELECTOR, gc);
    }
}