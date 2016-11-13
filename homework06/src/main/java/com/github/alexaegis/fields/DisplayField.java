package com.github.alexaegis.fields;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Window.WINDOW_WIDTH;
import static com.github.alexaegis.Window.BUTTON_SIZE;

public class DisplayField extends JTextField {

    public static final String DEFAULT_DISPLAY = "0";
    public static boolean empty = true;

    public DisplayField() {
        setEditable(false);
        setText(DEFAULT_DISPLAY);
        setPreferredSize(new Dimension(WINDOW_WIDTH - BUTTON_SIZE.width -2 , 24));
        setHorizontalAlignment(JTextField.RIGHT);
        setToolTipText("0");
    }
}