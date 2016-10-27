package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExampleView extends JFrame {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public ExampleView(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        
        createLeftPanel();
        createRightPanel();
        
    }
    
    private void createLeftPanel() {
        
    }

    private void createRightPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT / 2));
        panel.setBackground(Color.darkGray);
        addInput(panel, "First Name: ", new JTextField(10));
        addInput(panel, "Last Name: ", new JTextField(10));
        add(panel,BorderLayout.EAST);
    }

    private void addInput(JPanel panel, String name, JTextField jTextField) {
        panel.add(new JLabel(name));
        panel.add(jTextField);
    }

    
}