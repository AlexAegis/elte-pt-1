package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public class Pawn extends JLabel {

    private ImageIcon icon;

    public Pawn() {
        icon = new ImageIcon(scaleImage(new ImageIcon("r.png").getImage(), TILE_SIZE, TILE_SIZE));
        setPreferredSize(new Dimension(GRID_SIZE_DEFAULT / TILE_SIZE, GRID_SIZE_DEFAULT / TILE_SIZE));
        setBackground(Color.WHITE);
        setIcon(icon);
        setVisible(true);
    }

    private Image scaleImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

}