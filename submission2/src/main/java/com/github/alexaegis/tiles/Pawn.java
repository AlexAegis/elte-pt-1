package com.github.alexaegis.tiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public class Pawn extends JLabel {

    private ImageIcon icon;
    private int player;

    public Pawn(int player) {
        try {
            this.player = player;
            icon = new ImageIcon(scaleImage(ImageIO.read(Pawn.class.getClassLoader().getResourceAsStream(player + ".png")), TILE_SIZE, TILE_SIZE));
            setPreferredSize(new Dimension(GRID_SIZE_DEFAULT / TILE_SIZE, GRID_SIZE_DEFAULT / TILE_SIZE));
            setBackground(Color.WHITE);
            setIcon(icon);
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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