package exam.elements.panels;

import exam.ResizeableElement;
import exam.elements.buttons.*;
import exam.elements.labels.StepCounterLabel;
import exam.elements.labels.TimerLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static exam.config.Config.MENU_BG_COLOR;

public class Menu extends JPanel implements ResizeableElement {

    public static SizeSelector SIZESELECTOR = new SizeSelector();
    public static GameModeSelector GAMEMODESELECTOR = new GameModeSelector();
    public static MinRangeSelector MINRANGESELECTOR = new MinRangeSelector();
    public static MaxRangeSelector MAXRANGESELECTOR = new MaxRangeSelector();
    public static JLabel VALIDDIRSLABEL = new JLabel("Valid Directions:");
    public static CheckBoxPanel CHECKBOXPANEL = new CheckBoxPanel();
    public static TimerLabel TIMERLABEL = new TimerLabel();
    public static StepCounterLabel STEPCOUNTERLABEL = new StepCounterLabel();
    public static ModifierSelector MODIFIERSELECTOR = new ModifierSelector();

    public Menu() {
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(MENU_BG_COLOR);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.insets = new Insets(5, 5, 0, 5);
        gc.gridx = 0;
        gc.gridy = 0;
        add(new PlayButton(), gc);
        gc.gridx = 0;
        gc.gridy = 4;
        add(new CloseButton(), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        add(SIZESELECTOR, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(GAMEMODESELECTOR, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        add(new JLabel("Min rng:"), gc);
        gc.gridx = 3;
        gc.gridy = 0;
        add(MINRANGESELECTOR, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(new JLabel("Max rng:"), gc);
        gc.gridx = 3;
        gc.gridy = 1;
        add(MAXRANGESELECTOR, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(new JLabel("Modifier:"), gc);
        gc.gridx = 3;
        gc.gridy = 2;
        add(MODIFIERSELECTOR, gc);

        gc.gridx = 4;
        gc.gridy = 0;
        add(VALIDDIRSLABEL, gc);
        gc.gridx = 5;
        gc.gridy = 0;
        gc.gridheight = 4;
        add(CHECKBOXPANEL, gc);
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 3;
        gc.gridy = 3;
        gc.gridheight = 1;
        add(new Label("Time elapsed:"), gc);
        gc.gridx = 4;
        gc.gridy = 3;
        add(TIMERLABEL, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        add(new Label("Steps taken:"), gc);
        gc.gridx = 2;
        gc.gridy = 3;
        add(STEPCOUNTERLABEL, gc);
    }

    @Override
    public void onResize() {
        setSize(getParent().getSize());
        revalidate();
        repaint();
    }
}