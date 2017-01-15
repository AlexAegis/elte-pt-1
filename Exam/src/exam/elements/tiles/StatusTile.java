package exam.elements.tiles;

import exam.config.ResizeableElement;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.ANTI_ALIASING;
import static exam.config.Config.MENU_BG_COLOR;

public class StatusTile extends Tile implements ResizeableElement {

    private int correctColors = 0;
    private int correctPositions = 0;

    private Color backGround = MENU_BG_COLOR.brighter();

    public StatusTile(int width, int height) {
        colors = new Color[]{Color.gray, new Color(255,255,255,200)};
        this.width = width;
        this.height = height;
    }

    public StatusTile(Dimension dimension) {
        this((int) dimension.getWidth(), (int) dimension.getHeight());
    }

    public void setCorrectColorsAndPositions(int correctColors, int correctPositions) {
        this.correctColors = correctColors;
        this.correctPositions = correctPositions;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setPaint(new RadialGradientPaint(width / 2, height / 2,width * 3, dist, colors));
        g.fillRect(0, 0, height, width);
        ((Graphics2D) g).setPaint(Color.BLACK);
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