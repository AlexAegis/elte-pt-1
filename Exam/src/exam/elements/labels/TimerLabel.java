package exam.elements.labels;

import exam.logic.abstraction.StopWatch;

import javax.swing.*;
import java.awt.*;

public final class TimerLabel extends JLabel {

    private StopWatch stopWatch = new StopWatch();

    public TimerLabel() {
        setPreferredSize(new Dimension(80, 20));
        stopWatch.startThread();
        start();
    }

    public void start(){
        reset();
        Timer timer = new Timer(10, e -> {
            String minute = Integer.toString(stopWatch.getMinute());
            String second = Integer.toString(stopWatch.getSecond());
            String milliSecond = Integer.toString(stopWatch.getMilliSeconds() / 10);
            setText((Integer.valueOf(minute) < 10 ? " " + minute : minute)
                    + " : " + (Integer.valueOf(second) < 10 ? " " + second : second)
                    + " : " + (Integer.valueOf(milliSecond) < 100 && Integer.valueOf(milliSecond) >= 10
                                ? " " + milliSecond
                                : (Integer.valueOf(milliSecond) < 10 ? "   " + milliSecond : milliSecond)));
        });
        timer.start();
    }

    public void reset() {
        stopWatch.reset();
    }
}