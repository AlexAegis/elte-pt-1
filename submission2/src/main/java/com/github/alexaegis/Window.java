package com.github.alexaegis;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.panels.GamePanel;
import com.github.alexaegis.panels.MenuPanel;

import javax.swing.*;

import static com.github.alexaegis.Main.*;

public class Window extends JFrame {

    public Window() {
        setTitle(WINDOW_NAME_MAIN);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setResizable(WINDOW_RESIZEABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel(FieldSizeOptions.SIX)); //getContentPane().add(new MenuPanel());
    }
}