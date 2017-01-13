package exam;

import javax.swing.*;

import java.awt.*;

import static exam.config.Config.WINDOW_TITLE;

public final class Main {
    public static Window GAME_WINDOW;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            EventQueue.invokeLater(() -> GAME_WINDOW = new Window(WINDOW_TITLE));
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}