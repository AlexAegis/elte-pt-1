package exam.elements.tiles;

import exam.config.ResizeableElement;
import javax.swing.*;
import java.awt.*;

import static exam.config.Config.ANTI_ALIASING;

public final class Number extends JComponent implements ResizeableElement {

    private int value;
    private int width;
    private int height;

    public Number(int value, int width, int height) {
        this.value = value;
        this.width = width;
        this.height = height;
    }

    public Number(int value, Dimension dimension) {
        this(value, (int) dimension.getWidth(), (int) dimension.getHeight());
    }


    public int getValue() {
        return value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setPaint(Color.BLACK);
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, (int) (Math.min(height, width) * 0.8)));
        g.drawString(toString(), (int) (Math.min(height, width) * 0.1),  (int) (Math.min(height, width) * 0.8));
    }

    @Override
    public String toString() {
        return value < 10 ? "  " + Integer.toString(value) : Integer.toString(value) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return value == number.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public void modifyValue(int modifier) {
        value = value + modifier;
    }

    public boolean modifiable(int modifier, int min, int max) {
        return value + modifier >= min && value + modifier <= max;
    }

    public void setValue(int value) {
        this.value = value;
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