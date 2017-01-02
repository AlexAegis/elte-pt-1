package exam.tiles;

import javax.swing.*;
import java.awt.*;

public class Number extends JComponent {

    private int value;
    private int width;
    private int height;

    public Number(int value, int width, int height) {
        this.value = value;
        this.width = width;
        this.height = height;
    }

    public int getValue() {
        return value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setPaint(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, height / 10));
        g.drawString(toString(), 0, 0);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
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
}