package exam;

import exam.config.ResizeableElement;
import exam.elements.panels.ContentPane;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static exam.config.Config.*;
import static exam.config.Utilities.findComponents;

public final class Window extends JFrame implements ComponentListener {

    Window(String title) {
        setTitle(title);
        setSize(DEFAULT_WINDOW_WIDTH + 16, DEFAULT_WINDOW_HEIGHT);
        setResizable(WINDOW_RESIZABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new ContentPane());
        setVisible(true);
        addComponentListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if(ANTI_ALIASING) graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        DEFAULT_WINDOW_WIDTH = getWidth() - 16;
        DEFAULT_WINDOW_HEIGHT = getHeight() - 32;
        findComponents(this, ResizeableElement.class).forEach(ResizeableElement::onResize);
        revalidate();
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}