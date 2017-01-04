package exam.elements.tiles;

import exam.ResizeableElement;

import javax.swing.*;
import java.awt.*;

public final class HighLight extends JComponent implements ResizeableElement {
    private int width;
    private int height;

    private Color[] baseColors = {new Color(255, 255, 255, 180), new Color(255, 255, 255, 120)};
    private Color[] warmColors = {new Color(255, 71, 25, 180), new Color(255, 47, 0, 120)};
    private Color[] coldColors = {new Color(40, 170, 255, 180), new Color(25, 72, 255, 120)};
    private Color[] actualColors;

    public HighLight(int width, int height) {
        this.width = width;
        this.height = height;
        setLayout(new BorderLayout());
        switchToBase();
        setVisible(true);
    }

    public void switchToCold() {
        actualColors = coldColors;
    }

    public void switchToWarm() {
        actualColors = warmColors;
    }

    public void switchToBase() {
        actualColors = baseColors;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        float[] dist = {0.0f, 1.0f};

        g.setPaint(new RadialGradientPaint(width / 2, height / 2, width * 2, dist, actualColors));
        g.fillRect(0,0, width, height);
        g.setColor(new Color(0, 0, 0, 5));
        g.fillRect(width / 20 , height/ 20, width -  height / 10, height - width / 10);
    }

    @Override
    public void onResize() {
        setSize(getParent().getSize());
        width = getParent().getWidth();
        height = getParent().getHeight();
        revalidate();
        repaint();
    }
}