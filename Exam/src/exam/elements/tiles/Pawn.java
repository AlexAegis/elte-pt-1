package exam.elements.tiles;

import exam.ResizeableElement;

import javax.swing.*;
import java.awt.*;

public class Pawn extends JComponent implements ResizeableElement {

    private Color color;
    private Color colorMuter = new Color(232, 241, 219, 30);
    private int width;
    private int height;
    private int padding;
    private Paint paint;
    private boolean promotion = false;

    private int player;

    public Pawn(Color color, int player, int width, int height) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.padding = ((width + height) / 2) / 16;
        setLayout(new BorderLayout());
        Color[] colors = {color, new Color(255,255,255,200)};
        float[] dist = {0.2f, 1f};
        paint = new RadialGradientPaint(width / 2, height / 2,width, dist, colors);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
    }

    public int getPlayer() {
        return player;
    }

    public void promote() {
        promotion = true;
    }

    public boolean isPromoted() {
        return promotion;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        Polygon p = new Polygon();
        p.addPoint(padding + width / 5, height - padding - width / 10);
        p.addPoint(width - padding - width / 5, height - padding - width / 10);
        p.addPoint(width / 2, height / 10);

        g.fillPolygon(p);
        g.fillOval((width / 2) - (height / 6), padding, height / 3, height / 3);
    }

    public Pawn takeOff() {
        getParent().remove(this);
        return this;
    }


    @Override
    public String toString() {
        return (player == 1) ? "Red" : "Blue";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pawn pawn = (Pawn) o;

        return player == pawn.player;

    }

    @Override
    public int hashCode() {
        return player;
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
