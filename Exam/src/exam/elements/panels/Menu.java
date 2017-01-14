package exam.elements.panels;

import exam.config.ResizeableElement;
import exam.elements.buttons.*;
import exam.elements.labels.PlayerIndicator;
import exam.elements.labels.StepCounterLabel;
import exam.elements.labels.TimerLabel;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.*;

public class Menu extends JPanel implements ResizeableElement {

    private GridBagConstraints gc = new GridBagConstraints();

    // ROW 0

    public static PlayButton PLAYBUTTON = new PlayButton();                         // x:0,   y:0
    public static JLabel PLAYERINDICATORLABEL = new JLabel("Actual");          // x:2,   y:0
    public static PlayerIndicator PLAYERINDICATOR = new PlayerIndicator();          // x:3,   y:0
    public static JLabel VALIDDIRSLABEL = new JLabel("Valid Directions:");     // x:4-5, y:0
    public static CheckBoxPanel CHECKBOXPANEL = new CheckBoxPanel();                // x:6,   y:0-5

    // ROW 1

    public static JLabel MODELABEL = new JLabel("Mode:");                      // x:0,   y:1
    public static GameModeSelector GAMEMODESELECTOR = new GameModeSelector();       // x:1,   y:1

    // ROW 2

    public static JLabel SIZELABEL = new JLabel("Size:");                      // x:0,   y:2
    public static SizeSelector SIZESELECTOR = new SizeSelector();                   // x:1,   y:2
    public static JLabel CUSTOMNSELECTORLABEL = new JLabel("N:");              // x:2,   y:2
    public static RangeSelector CUSTOMNSELECTOR = new RangeSelector();              // x:3,   y:2
    public static JLabel CUSTOMMSELECTORLABEL = new JLabel("M:");              // x:4,   y:2
    public static RangeSelector CUSTOMMSELECTOR = new RangeSelector();              // x:5,   y:2

    // ROW 3

    public static JLabel RNGLABEL = new JLabel("Rng:");                        // x:0,   y:3
    public static JLabel MINRNGLABEL = new JLabel("Min:");                     // x:2,   y:3
    public static RangeSelector MINRNGSELECTOR = new RangeSelector();               // x:3,   y:3
    public static JLabel MAXRNGLABEL = new JLabel("Max:");                     // x:4,   y:3
    public static RangeSelector MAXRNGSELECTOR = new RangeSelector();               // x:5,   y:3

    // ROW 4 FOR NUMBERGAME

    public static JLabel MODIFIERLABEL = new JLabel("Mod:");                   // x:0,   y:4
    public static ModifierSelector MODIFIERSELECTOR = new ModifierSelector();       // x:1,   y:4

    // ROW 4 FOR COLOURGAME

    public static JLabel DIFFLABEL = new JLabel("Diff:");                      // x:0,   y:4
    public static RangeSelector DIFFSELECTOR = new RangeSelector();                 // x:1,   y:4
    public static JLabel HINTLABEL = new JLabel("Hint:");                      // x:2,   y:4
    public static HintButton HINTBUTTON = new HintButton();                         // x:3,   y:4

    // ROW 5

    public static CloseButton CLOSEBUTTON = new CloseButton();                      // x:0,   y:5
    public static JLabel STEPCOUNTERLABEL = new JLabel("Steps:");              // x:2,   y:5
    public static StepCounterLabel STEPCOUNTER = new StepCounterLabel();            // x:3,   y:5
    public static JLabel TIMERLABEL = new JLabel("Time:");                     // x:4,   y:5
    public static TimerLabel TIMER = new TimerLabel();                              // x:5,   y:5


    public Menu() {
        setLayout(new GridBagLayout());
        setBackground(MENU_BG_COLOR);

        MINRNGSELECTOR.setText(Integer.toString(DEFAULT_MIN_RNG));
        MAXRNGSELECTOR.setText(Integer.toString(DEFAULT_MAX_RNG));
        CUSTOMNSELECTOR.setText(Integer.toString(DEFAULT_CUSTOM_N));
        CUSTOMMSELECTOR.setText(Integer.toString(DEFAULT_CUSTOM_M));

        resetConstraints();
        putRowZero();
        putRowOne();
        putRowTwo();
        putRowThree();
        putRowFour();
        putRowFive();

        CUSTOMNSELECTORLABEL.setVisible(false);
        CUSTOMNSELECTOR.setVisible(false);
        CUSTOMMSELECTORLABEL.setVisible(false);
        CUSTOMMSELECTOR.setVisible(false);
    }

    private void putRowZero() {
        gc.gridy = 0;

        gc.gridx = 0;
        add(PLAYBUTTON, gc);
        gc.gridx = 2;
        add(PLAYERINDICATORLABEL, gc);
        gc.gridx = 3;
        add(PLAYERINDICATOR, gc);
        gc.gridx = 4;
        gc.gridwidth = 2;
        add(VALIDDIRSLABEL, gc);
        gc.gridwidth = 1;
        gc.gridheight = 6;
        gc.gridx = 6;
        add(CHECKBOXPANEL, gc);
        resetConstraints();
    }

    private void putRowOne() {
        gc.gridy = 1;

        gc.gridx = 0;
        add(MODELABEL, gc);
        gc.gridx = 1;
        add(GAMEMODESELECTOR, gc);
        resetConstraints();
    }

    private void putRowTwo() {
        gc.gridy = 2;

        gc.gridx = 0;
        add(SIZELABEL, gc);
        gc.gridx = 1;
        add(SIZESELECTOR, gc);
        gc.gridx = 2;
        add(CUSTOMNSELECTORLABEL, gc);
        gc.gridx = 3;
        add(CUSTOMNSELECTOR, gc);
        gc.gridx = 4;
        add(CUSTOMMSELECTORLABEL, gc);
        gc.gridx = 5;
        add(CUSTOMMSELECTOR, gc);
        resetConstraints();
    }

    private void putRowThree() {
        gc.gridy = 3;

        gc.gridx = 0;
        add(RNGLABEL, gc);
        gc.gridx = 2;
        add(MINRNGLABEL, gc);
        gc.gridx = 3;
        add(MINRNGSELECTOR, gc);
        gc.gridx = 4;
        add(MAXRNGLABEL, gc);
        gc.gridx = 5;
        add(MAXRNGSELECTOR, gc);
        resetConstraints();
    }

    private void putRowFour() {
        gc.gridy = 4;
        gc.gridx = 0;
        add(MODIFIERLABEL, gc);
        gc.gridx = 1;
        add(MODIFIERSELECTOR, gc);
        gc.gridx = 2;
        add(DIFFLABEL, gc);
        gc.gridx = 3;
        add(DIFFSELECTOR, gc);
        gc.gridx = 4;
        add(HINTLABEL, gc);
        gc.gridx = 5;
        add(HINTBUTTON, gc);
        resetConstraints();
    }

    private void putRowFive() {
        gc.gridy = 5;

        gc.gridx = 0;
        add(CLOSEBUTTON, gc);
        gc.gridx = 2;
        add(STEPCOUNTERLABEL, gc);
        gc.gridx = 3;
        add(STEPCOUNTER, gc);
        gc.gridx = 4;
        add(TIMERLABEL, gc);
        gc.gridx = 5;
        add(TIMER, gc);
        resetConstraints();
    }

    private void resetConstraints() {
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.gridheight = 1;
        gc.gridwidth = 1;
        gc.insets = new Insets(2, 2, 0, 2);
        gc.gridx = 0;
        gc.gridy = 0;
    }

    @Override
    public void onResize() {
        revalidate();
        repaint();
    }
}