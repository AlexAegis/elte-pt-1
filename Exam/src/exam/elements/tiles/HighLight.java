package exam.elements.tiles;

import exam.config.ResizeableElement;

import javax.swing.*;
import java.awt.*;

public class HighLight extends JComponent implements ResizeableElement {
    private int width;
    private int height;

    public static Color[] baseColors = {new Color(255, 255, 255, 180), new Color(255, 255, 255, 120)};
    public static Color[] warmColors = {new Color(255, 71, 25, 180), new Color(255, 47, 0, 120)};
    public static Color[] coldColors = {new Color(40, 170, 255, 180), new Color(25, 72, 255, 120)};
    public static Color[] naturalColors = {new Color(99, 255, 125, 180), new Color(0, 255, 30, 120)};
    private Color[] actualColors;

    public HighLight() {
    }

    public HighLight(int width, int height) {
        this.width = width;
        this.height = height;
        setLayout(new BorderLayout());
        switchToBase();
        switchToNatural(); // Delete to resume base
        setVisible(true);
    }

    public Color[] getActualColors() {
        return actualColors;
    }

    public HighLight switchToCold() {
        actualColors = coldColors;
        return this;
    }

    public HighLight switchToWarm() {
        actualColors = warmColors;
        return this;
    }

    public HighLight switchToBase() {
        actualColors = baseColors;
        return this;
    }

    public HighLight switchToNatural() {
        actualColors = naturalColors;
        return this;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        float[] dist = {0.0f, 1.0f};

        g.setPaint(new RadialGradientPaint(width / 2, height / 2, width * 2, dist, actualColors));
        g.fillRect(0,0, height, width);
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