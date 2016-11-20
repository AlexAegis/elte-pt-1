package com.github.alexaegis.logic;


import static com.github.alexaegis.Main.GRID_SIZE_DEFAULT;
import static com.github.alexaegis.Main.TILE_SIZE;

public enum FieldSizeOptions {
    SIX(6, 6),
    EIGTH(8, 8),
    TEN(10, 10),
    CUSTOM(10, 10);

    private int n;
    private int m;
    private int customN;
    private int customM;

    FieldSizeOptions(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getWidth() {
        if(this.equals(FieldSizeOptions.CUSTOM)) {
            return customN;
        } else {
            return n;
        }
    }

    public int getHeight() {
        if(this.equals(FieldSizeOptions.CUSTOM)) {
            return customM;
        } else {
            return m;
        }
    }

    public void setCustomSize(int n, int m) {
        customN = n;
        customM = m;
    }

    @Override
    public String toString() {
        if(this.equals(FieldSizeOptions.CUSTOM)) {
            return "Custom";
        }
        return n + " by " + m;
    }
}