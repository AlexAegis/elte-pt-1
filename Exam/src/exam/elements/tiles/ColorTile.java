package exam.elements.tiles;

import exam.config.ResizeableElement;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.ANTI_ALIASING;

public class ColorTile extends JComponent implements ResizeableElement {

    private Color color;
    private int width;
    private int height;

    private Color[] colors;
    private float[] dist;

    public ColorTile(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;

        colors = new Color[]{color, new Color(87, 86, 80, 53)};
        dist = new float[]{0.08f, 1f};
    }

    public Color getColor() {
        return color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setPaint( new RadialGradientPaint(width / 2, height / 2,width * 2, dist, colors));
        g.fillRect(0, 0, width, height);
    }

    @Override
    public String toString() {
        return color.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorTile colorTile = (ColorTile) o;

        return color == colorTile.color;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
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
