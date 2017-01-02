package exam.panels;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.*;

public class Game extends JPanel {

    public static final Color GAME_BG_COLOR = new Color(162, 149, 147, 255);

    public Game() {
        setLayout(null);
        setBounds(0,0,WINDOW_WIDTH, WINDOW_WIDTH);
        setBackground(GAME_BG_COLOR);
        if(START_WITH_DEFAULT) add(
                new Grid(DEFAULT_FIELDSIZE, DEFAULT_GAMEMODE, DEFAULT_MIN_RNG, DEFAULT_MAX_RNG, null));
    }
}