package exam.elements.labels;

import javax.swing.*;
import java.awt.*;

public class PlayerIndicator extends JButton {

    private Paint actualPlayerColor = Color.BLACK;

    public PlayerIndicator() {
        setBounds(0,0,120,60);
        setSize(new Dimension(120, 60));
        setPreferredSize(new Dimension(120, 60));
        setVisible(true);
        System.out.println("asd");
        repaint();
    }

    public void setIndicatorColor(Color actualPlayerColor) {
        this.actualPlayerColor = actualPlayerColor;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setPaint(actualPlayerColor);
        graphics.fillRect(0, 0, 120, 60);
    }
}