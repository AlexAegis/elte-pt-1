package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExampleView extends JFrame {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    private JTextArea jTextArea = new JTextArea(10,6);
    private AbstractAction exampleAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String str = String.format(
                    "Button: %s pressed\n", button.getText()
            );
            jTextArea.append(str);
        }
    };
    
    public ExampleView(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        
        createLeftPanel();
        createRightPanel();
        createLeftTopPanel();
        createRightTopPanel();
    }
    
    private void createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 20));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(createLeftTopPanel());
        panel.add(createRightTopPanel());
        add(panel,BorderLayout.WEST);
    }

    private void createRightPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, HEIGHT / 2));
        panel.setBackground(Color.darkGray);
        addInput(panel, "First Name: ", new JTextField(10));
        addInput(panel, "Last Name: ", new JTextField(10));
        
        add(panel,BorderLayout.EAST);
    }
    
    private JPanel createLeftTopPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 50));
        panel.setBackground(Color.orange);
        addInput(panel, "LOL: ", new JTextArea(5,5));
        return panel;
    }
    
    private JPanel createRightTopPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 6, 20, 10));
        panel.setSize(600, 300);
        for(int i = 0; i < 5 * 6; i++) {
            JButton button = new JButton();
            button.setText(Integer.toString(i));
          
            panel.setBackground(Color.red);
            panel.add(button);
        }
        panel.add(this.jTextArea);
        return panel;
    }

    private void addInput(JPanel panel, String name, JTextField jTextField) {
        panel.add(new JLabel(name));
        panel.add(jTextField);
    }
     private void addInput(JPanel panel, String name, JTextArea jTextArea) {
        panel.add(new JLabel(name));
        panel.add(jTextArea);
    }

    
}