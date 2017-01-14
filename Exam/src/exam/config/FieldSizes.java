package exam.config;

import static exam.config.Config.DEFAULT_CUSTOM_M;
import static exam.config.Config.DEFAULT_CUSTOM_N;
import static exam.config.Config.START_WITH_DEFAULT;
import static exam.elements.panels.Menu.*;

public enum FieldSizes {
    FOUR(4, 4),
    FIVE(5, 5),
    SEVEN(7, 7),
    EIGHT(8, 8),
    TEN(10, 10),
    TWELVE(12, 12),
    CUSTOM(DEFAULT_CUSTOM_N, DEFAULT_CUSTOM_M);

    private int n;
    private int m;

    FieldSizes(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getN() {
        if(this.equals(CUSTOM) && CUSTOMNSELECTOR.getText().chars().allMatch(Character::isDigit)) {
            return Integer.valueOf(CUSTOMNSELECTOR.getText());
        } else {
            return n;
        }
    }

    public int getM() {
        if(this.equals(CUSTOM) && CUSTOMMSELECTOR.getText().chars().allMatch(Character::isDigit)) {
            return Integer.valueOf(CUSTOMMSELECTOR.getText());
        } else {
            return m;
        }
    }

    @Override
    public String toString() {
        if(this.equals(CUSTOM)) {
            return "Custom";
        } else {
            return n + " by " + m;
        }
    }
}