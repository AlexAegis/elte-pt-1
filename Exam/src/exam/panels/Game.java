package exam.panels;

import exam.config.FieldSizes;
import exam.config.GameModes;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.WINDOW_WIDTH;

public class Game extends JPanel {

    public static final Color GAME_BG_COLOR = new Color(162, 149, 147, 255);

    public Game() {
        setLayout(null);
        setBounds(0,0,WINDOW_WIDTH, WINDOW_WIDTH);
        setBackground(GAME_BG_COLOR);
        add(new Grid(FieldSizes.SEVEN, GameModes.NUMBER_GAME));
    }
}
