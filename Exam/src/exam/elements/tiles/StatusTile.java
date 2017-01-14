package exam.elements.tiles;

import exam.config.ResizeableElement;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.ANTI_ALIASING;

public class StatusTile extends JComponent implements ResizeableElement {

    private int width;
    private int height;

    private int correctColors = 0;
    private int correctPositions = 0;

    public StatusTile(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setCorrectColorsAndPositions(int correctColors, int correctPositions) {
        this.correctColors = correctColors;
        this.correctPositions = correctPositions;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setPaint(Color.BLACK);
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, (int) (Math.min(height, width) * 0.2)));
        g.drawString("Colors: " + correctColors, (int) (Math.min(height, width) * 0.1),  (int) (Math.min(height, width) * 0.8));
        g.drawString("Places: " + correctPositions, (int) (Math.min(height, width) * 0.1),  (int) (Math.min(height, width) * 0.5));
    }

    @Override
    public String toString() {
        return "Colors: " + correctColors + " Pos: " + correctPositions;
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
