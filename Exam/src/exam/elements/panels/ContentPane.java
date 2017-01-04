package exam.elements.panels;

import exam.config.ResizeableElement;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.DEFAULT_WINDOW_HEIGHT;
import static exam.config.Config.DEFAULT_WINDOW_WIDTH;

public class ContentPane extends JLayeredPane implements ResizeableElement {

    public static Game GAME = new Game();
    private static ControlPane MENU = new ControlPane();

    public ContentPane() {
        setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        setLayout(null);
        add(GAME);
        add(MENU);
        setBackground(new Color(130, 162, 182, 255));
    }

    @Override
    public void onResize() {
        setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        revalidate();
        repaint();
    }
}