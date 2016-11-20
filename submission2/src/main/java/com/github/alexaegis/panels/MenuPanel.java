package com.github.alexaegis.panels;

import com.github.alexaegis.elements.*;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.WINDOW_HEIGHT;
import static com.github.alexaegis.Main.WINDOW_WIDTH;

public class MenuPanel extends JPanel {

    JButton play = new PlayButton();
    JButton exit = new ExitButton();
    JComboBox fieldSelector = new GameFieldSelector();
    JComboBox modeSelector = new GameModeSelector();
    JComboBox numberSelector1 = new NumberSelector();
    JComboBox numberSelector2 = new NumberSelector();

    public MenuPanel() {

        setPreferredSize(new Dimension(240,240));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.insets = new Insets(10,0,10,10);
        constraints.anchor = GridBagConstraints.WEST;
        add(play, constraints);

        constraints.gridy = 1;
        constraints.gridx = 1;
        add(modeSelector, constraints);

        constraints.gridy = 2;
        constraints.gridx = 1;
        add(fieldSelector, constraints);

        constraints.gridy = 3;
        constraints.gridx = 1;
        add(exit, constraints);
        constraints.insets = new Insets(0, 0, 0, 0);
        /*
        constraints.gridy = 2;
        constraints.gridx = 2;
        add(numberSelector1, constraints);

        constraints.gridy = 2;
        constraints.gridx = 3;
        add(new JLabel(" by "), constraints);

        constraints.gridy = 2;
        constraints.gridx = 4;
        add(numberSelector2, constraints);*/

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(new JLabel("Size of the gamefield: "), constraints);

        constraints.gridy = 0;
        constraints.gridx = 4;
        add(Box.createHorizontalStrut(200), constraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(new GradientPaint(0, 0, new Color(25, 89, 138,255), WINDOW_WIDTH, WINDOW_HEIGHT / 2 ,new Color(70, 83, 167,255)));
        graphics.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}