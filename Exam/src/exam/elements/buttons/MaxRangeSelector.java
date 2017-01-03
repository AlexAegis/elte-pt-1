package exam.elements.buttons;

import static exam.config.Config.DEFAULT_MAX_RNG;

public class MaxRangeSelector extends RangeSelector {
    public MaxRangeSelector() {
        setText(Integer.toString(DEFAULT_MAX_RNG));
    }
}