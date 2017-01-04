package exam.elements.panels;

import exam.ResizeableElement;

import javax.swing.*;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static exam.config.Config.*;

public class Game extends JPanel implements ResizeableElement {
    public Game() {
        setLayout(null);
        setBounds(0,0,WINDOW_WIDTH, WINDOW_WIDTH);
        setBackground(GAME_BG_COLOR);
        if(START_WITH_DEFAULT) add(
                new Grid(DEFAULT_FIELDSIZE, DEFAULT_GAMEMODE, DEFAULT_MIN_RNG, DEFAULT_MODIFIER_VALUE, DEFAULT_MAX_RNG, null));
    }

    @Override
    public void onResize() {
        setBounds(0,0,WINDOW_WIDTH, WINDOW_WIDTH);
        revalidate();
        repaint();
    }
}