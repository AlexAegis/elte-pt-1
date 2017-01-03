package exam.elements.buttons;

import static exam.config.Config.DEFAULT_MIN_RNG;

public class MinRangeSelector extends RangeSelector {
    public MinRangeSelector() {
        setText(Integer.toString(DEFAULT_MIN_RNG));
    }
}