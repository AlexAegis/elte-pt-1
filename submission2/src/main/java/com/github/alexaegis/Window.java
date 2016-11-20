package com.github.alexaegis;

import com.github.alexaegis.panels.MenuPanel;

import javax.swing.*;

import static com.github.alexaegis.Main.*;

public class Window extends JFrame {

    public Window() {
        setTitle(WINDOW_NAME_MAIN);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(WINDOW_RESIZEABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new MenuPanel());
        revalidate();
        repaint();
    }
}