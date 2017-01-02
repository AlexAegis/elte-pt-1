package exam.panels;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.WINDOW_HEIGHT;
import static exam.config.Config.WINDOW_WIDTH;

public class ContentPane extends JLayeredPane {

    public static Game GAME = new Game();
    public static Menu MENU = new Menu();

    public ContentPane() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);
        add(GAME);
        add(MENU);
        setBackground(new Color(130, 162, 182, 255));
    }
}
