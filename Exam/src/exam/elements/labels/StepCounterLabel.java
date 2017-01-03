package exam.elements.labels;

import javax.swing.*;
import java.awt.*;

public final class StepCounterLabel extends JLabel {
    private static int stepCount = 0;

    public StepCounterLabel() {
        setPreferredSize(new Dimension(80, 20));
        setText(Integer.toString(stepCount));
    }

    public static int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        StepCounterLabel.stepCount = stepCount;
        setText(Integer.toString(stepCount));
        revalidate();
        repaint();
    }

    public void increase() {
        setStepCount(getStepCount() + 1);
    }

    public void reset() {
        stepCount = 0;
    }
}