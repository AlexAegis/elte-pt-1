package exam.panels;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.WINDOW_HEIGHT;
import static exam.config.Config.WINDOW_WIDTH;

public class ControlPane extends JPanel {

    public static final Color MENU_BG_COLOR = new Color(226, 210, 202, 255);

    public ControlPane() {
        setLayout(null);
        setBounds(0, WINDOW_WIDTH, WINDOW_WIDTH, WINDOW_HEIGHT - WINDOW_WIDTH);
        Menu menu = new Menu();
        menu.setBounds(0,0, (int) (WINDOW_WIDTH * 1),WINDOW_HEIGHT - WINDOW_WIDTH);
        add(menu);
        setBackground(MENU_BG_COLOR);
    }
}