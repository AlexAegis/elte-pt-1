package exam.elements.panels;


import exam.ResizeableElement;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.WINDOW_HEIGHT;
import static exam.config.Config.WINDOW_WIDTH;

public class ContentPane extends JLayeredPane implements ResizeableElement {

    public static Game GAME = new Game();
    private static ControlPane MENU = new ControlPane();

    public ContentPane() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);
        add(GAME);
        add(MENU);
        setBackground(new Color(130, 162, 182, 255));
    }

    @Override
    public void onResize() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        revalidate();
        repaint();
    }
}