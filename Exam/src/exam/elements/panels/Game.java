package exam.elements.panels;

import exam.config.ResizeableElement;

import javax.swing.*;

import static exam.config.Config.*;

public class Game extends JPanel implements ResizeableElement {
    public Game() {
        setLayout(null);
        setBounds(0,0, Math.min(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT), Math.min(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT));
        setBackground(GAME_BG_COLOR);
        if(START_WITH_DEFAULT) add(
                new Grid(DEFAULT_FIELDSIZE, DEFAULT_GAMEMODE, DEFAULT_MIN_RNG, DEFAULT_MODIFIER_VALUE, DEFAULT_MAX_RNG, null));
    }

    @Override
    public void onResize() {
        setBounds(0,0, Math.min(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT), Math.min(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT));
        revalidate();
        repaint();
    }
}