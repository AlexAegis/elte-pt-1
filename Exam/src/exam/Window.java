package exam;

import exam.elements.panels.ContentPane;

import javax.swing.*;

import java.awt.*;

import static exam.config.Config.*;

final class Window extends JFrame {

    Window(String title) {
        setTitle(title);
        setSize(WINDOW_WIDTH + 6, WINDOW_HEIGHT);
        setResizable(WINDOW_RESIZABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new ContentPane());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if(ANTI_ALIASING) graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
}