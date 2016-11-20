package com.github.alexaegis.elements;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class GameButton extends JButton {

    private float[] fractions = {0.0f, 1.0f};
    private Color[] colorsDefault = {new Color(86, 114, 223,255), new Color(66, 143, 214,255)};
    private Color[] colorsHover = {new Color(111, 140, 223,255), new Color(51, 168, 254,255)};
    private Color[] colorsPress = {new Color(36, 70, 122,255), new Color(21, 37, 96,255)};

    protected String name;
    private RadialGradientPaint defaultPaint = new RadialGradientPaint(BUTTON_SIZE.width / 2, BUTTON_SIZE.height / 2, BUTTON_SIZE.width * 2,fractions, colorsDefault);
    private RadialGradientPaint hoverPaint = new RadialGradientPaint(BUTTON_SIZE.width / 2, BUTTON_SIZE.height / 2, BUTTON_SIZE.width * 2,fractions, colorsHover);
    private RadialGradientPaint pressPaint = new RadialGradientPaint(BUTTON_SIZE.width / 2, BUTTON_SIZE.height / 2, BUTTON_SIZE.width * 2,fractions, colorsPress);
    private Paint actualPaint = defaultPaint;

    public GameButton() {
        setSize(BUTTON_SIZE);
        setPreferredSize(BUTTON_SIZE);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent evt) {
                actualPaint = hoverPaint;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                actualPaint = defaultPaint;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                actualPaint = pressPaint;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                actualPaint = defaultPaint;
                repaint();
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setPaint(actualPaint);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setFont(new Font("Century Gothic", Font.PLAIN, getHeight() - 10));
        graphics.setPaint(new Color(0, 0, 0, 160));
        graphics.drawString(name, 10, getHeight() - 10);
    }

}