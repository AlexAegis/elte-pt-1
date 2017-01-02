package exam.panels;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.WINDOW_HEIGHT;
import static exam.config.Config.WINDOW_WIDTH;

public class Menu extends JPanel {

    public static final Color MENU_BG_COLOR = new Color(226, 210, 202, 255);

    public Menu() {
        setLayout(null);
        setBounds(0, WINDOW_WIDTH, WINDOW_WIDTH, WINDOW_HEIGHT - WINDOW_WIDTH);
        ControlPane cp = new ControlPane();
        cp.setBounds(0,0,200,WINDOW_HEIGHT - WINDOW_WIDTH);
        add(cp);
        setBackground(MENU_BG_COLOR);
    }
}
