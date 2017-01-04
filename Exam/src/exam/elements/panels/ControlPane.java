package exam.elements.panels;

import exam.ResizeableElement;

import javax.swing.*;

import static exam.config.Config.MENU_BG_COLOR;
import static exam.config.Config.WINDOW_HEIGHT;
import static exam.config.Config.WINDOW_WIDTH;

public class ControlPane extends JPanel implements ResizeableElement {
    Menu menu = new Menu();

    public ControlPane() {
        setLayout(null);
        setBounds(0, WINDOW_WIDTH, WINDOW_WIDTH, WINDOW_HEIGHT - WINDOW_WIDTH);
        menu.setBounds(0,0, WINDOW_WIDTH,WINDOW_HEIGHT - WINDOW_WIDTH);
        add(menu);
        setBackground(MENU_BG_COLOR);
    }

    @Override
    public void onResize() {
        setBounds(0, WINDOW_WIDTH, WINDOW_WIDTH, WINDOW_HEIGHT - WINDOW_WIDTH);
        menu.setBounds(0,0, WINDOW_WIDTH,WINDOW_HEIGHT - WINDOW_WIDTH);
        revalidate();
        repaint();
    }
}