package exam;

import exam.panels.ContentPane;

import javax.swing.*;

import java.awt.*;

import static exam.config.Config.*;

public final class Window extends JFrame {

    public Window(String title) {
        setTitle(title);
        setSize(WINDOW_WIDTH + 6, WINDOW_HEIGHT);
        setResizable(WINDOW_RESIZABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new ContentPane());
        revalidate();
        repaint();
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