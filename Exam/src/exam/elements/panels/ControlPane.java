package exam.elements.panels;

import exam.config.ResizeableElement;

import javax.swing.*;

import static exam.config.Config.MENU_BG_COLOR;
import static exam.config.Config.DEFAULT_WINDOW_HEIGHT;
import static exam.config.Config.DEFAULT_WINDOW_WIDTH;

public class ControlPane extends JPanel implements ResizeableElement {
    Menu menu = new Menu();

    public ControlPane() {
        setLayout(null);
        if(DEFAULT_WINDOW_HEIGHT > DEFAULT_WINDOW_WIDTH) {
            setBounds(0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT - DEFAULT_WINDOW_WIDTH);
            menu.setBounds(0,0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT - DEFAULT_WINDOW_WIDTH);
        } else {
            setBounds(DEFAULT_WINDOW_HEIGHT, 0, DEFAULT_WINDOW_WIDTH - DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_HEIGHT);
            menu.setBounds(0,0, DEFAULT_WINDOW_WIDTH - DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_HEIGHT);
        }

        add(menu);
        setBackground(MENU_BG_COLOR);
    }

    @Override
    public void onResize() {
        if(DEFAULT_WINDOW_HEIGHT > DEFAULT_WINDOW_WIDTH) {
            setBounds(0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT - DEFAULT_WINDOW_WIDTH);
            menu.setBounds(0,0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT - DEFAULT_WINDOW_WIDTH);
        } else {
            setBounds(DEFAULT_WINDOW_HEIGHT, 0, DEFAULT_WINDOW_WIDTH - DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_HEIGHT);
            menu.setBounds(0,0, DEFAULT_WINDOW_WIDTH - DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_HEIGHT);
        }
        revalidate();
        repaint();
    }
}