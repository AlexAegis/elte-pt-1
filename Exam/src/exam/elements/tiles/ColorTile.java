package exam.elements.tiles;

import exam.config.ResizeableElement;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exam.config.Config.ANTI_ALIASING;

public class ColorTile extends JComponent implements ResizeableElement {

    private List<Color> colors;
    private int width;
    private int height;
    private Color actualColor;
    private Color displayColor;
    private boolean isActivated = false;

    private Color deactivatedColor = Color.black;

    private float[] dist = new float[]{0.08f, 1f};

    public ColorTile(List<Color> colors, int width, int height) {
        this.colors = new ArrayList<>(colors);
        this.width = width;
        this.height = height;
        Collections.rotate(this.colors, new Random().nextInt(this.colors.size()));
        displayColor = this.colors.get(0);
        actualColor = this.colors.get(0);
        deactivatedColor = actualColor.darker().darker().darker().darker();
        deactivate();
        setSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void activate() {
        displayColor = actualColor;
        revalidate();
        repaint();
        isActivated = true;
    }

    public void deactivate() {
        displayColor = actualColor.darker().darker().darker().darker();
        revalidate();
        repaint();
        isActivated = false;
    }

    public void nextColor() {
        Collections.rotate(this.colors,-1);
        actualColor = colors.get(0);
        displayColor = actualColor;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color[] colorGradient = new Color[]{displayColor, new Color(87, 86, 80, 53)};
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setPaint( new RadialGradientPaint(height / 2, width / 2,width * 3, dist, colorGradient));
        g.fillRect(0, 0, height, width);
    }

    @Override
    public String toString() {
        return colors.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorTile colorTile = (ColorTile) o;

        return colors == colorTile.colors;
    }

    @Override
    public int hashCode() {
        return colors.hashCode();
    }

    @Override
    public void onResize() {
        setSize(getParent().getSize());
        width = getParent().getWidth();
        height = getParent().getHeight();
        revalidate();
        repaint();
    }

    public Color getActualColor() {
        return actualColor;
    }
}
