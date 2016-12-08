package com.github.alexaegis.logic;

public enum FieldSizeOptions {
    TWELVE(12, 12),
    TEN(10, 10),
    EIGHT(8, 8),
    SIX(6, 6);

    private int n;
    private int m;

    FieldSizeOptions(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getWidth() {
        return n;
    }

    public int getHeight() {
        return m;
    }

    @Override
    public String toString() {
        return n + " by " + m;
    }
}