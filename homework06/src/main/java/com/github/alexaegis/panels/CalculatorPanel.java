package com.github.alexaegis.panels;

import com.github.alexaegis.buttons.ClearButton;
import com.github.alexaegis.buttons.NumberButton;
import com.github.alexaegis.buttons.OperationButton;
import com.github.alexaegis.fields.DisplayField;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;
import static com.github.alexaegis.Window.WINDOW_HEIGHT;
import static com.github.alexaegis.Window.WINDOW_WIDTH;

public class CalculatorPanel extends JPanel {

    private GridBagConstraints c = new GridBagConstraints();

    private static DisplayField displayField = new DisplayField();

    public CalculatorPanel() {
        setLayout(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        add(displayField, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridx = 0;
        add(new ClearButton(), c);
        c.gridx = 1;
        add(new OperationButton("="), c);
        c.gridx = 2;
        add(new OperationButton("/"), c);
        c.gridx = 3;
        add(new OperationButton("*"), c);

        c.gridy = 2;
        c.gridx = 0;
        add(new NumberButton(7), c);
        c.gridx = 1;
        add(new NumberButton(8), c);
        c.gridx = 2;
        add(new NumberButton(9), c);
        c.gridx = 3;
        add(new OperationButton("-"), c);

        c.gridy = 3;
        c.gridx = 0;
        add(new NumberButton(4), c);
        c.gridx = 1;
        add(new NumberButton(5), c);
        c.gridx = 2;
        add(new NumberButton(6), c);
        c.gridx = 3;
        add(new OperationButton("+"), c);
        c.gridy = 4;
        c.gridx = 0;
        add(new NumberButton(1), c);
        c.gridx = 1;
        add(new NumberButton(2), c);
        c.gridx = 2;
        add(new NumberButton(3), c);
        c.gridx = 3;

        c.gridheight = 2;
        OperationButton equation = new OperationButton("=");
        equation.setPreferredSize(new Dimension((int) Math.round(BUTTON_SIZE.getWidth()), (int) Math.round(BUTTON_SIZE.getHeight()) * 2));
        add(equation, c);
        c.gridheight = 1;
        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 2;
        NumberButton zero = new NumberButton(0);
        zero.setPreferredSize(new Dimension((int) Math.round(BUTTON_SIZE.getWidth()) * 2, (int) Math.round(BUTTON_SIZE.getHeight())));
        add(zero, c);
        c.gridx = 2;
        c.gridwidth = 1;
        add(new OperationButton("."), c);
    }

    public static DisplayField getDisplayField() {
        return displayField;
    }
}