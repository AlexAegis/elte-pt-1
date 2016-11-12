package com.github.alexaegis.fields;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Window.WINDOW_WIDTH;

public class DisplayField extends JTextField {

    public static final String DEFAULT_DISPLAY = "0";

    public DisplayField() {
        setEditable(false);
        setText(DEFAULT_DISPLAY);
        //setPreferredSize(new Dimension(WINDOW_WIDTH - 8, 24));
    }
}