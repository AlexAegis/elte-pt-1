package exam.panels;

import exam.buttons.*;

import javax.swing.*;
import java.awt.*;

import static exam.panels.ControlPane.MENU_BG_COLOR;

public class Menu extends JPanel {

    private GridBagConstraints gc = new GridBagConstraints();
    public static SizeSelector SIZESELECTOR = new SizeSelector();
    public static GameModeSelector GAMEMODESELECTOR = new GameModeSelector();
    public static MinRangeSelector MINRANGESELECTOR = new MinRangeSelector();
    public static MaxRangeSelector MAXRANGESELECTOR = new MaxRangeSelector();

    public Menu() {
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
        gc.gridy = 2;
        add(new CloseButton(), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        add(SIZESELECTOR, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(GAMEMODESELECTOR, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        add(MINRANGESELECTOR, gc);
        gc.gridx = 3;
        gc.gridy = 0;
        add(MAXRANGESELECTOR, gc);
    }
}