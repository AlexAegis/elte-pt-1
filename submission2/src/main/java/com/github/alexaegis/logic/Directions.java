package com.github.alexaegis.logic;

import java.util.Arrays;

public enum Directions {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPLEFT(-1, 1),
    UPRIGHT(1, 1),
    DOWNLEFT(-1, -1),
    DOWNRIGHT(1, -1);

    private int x;
    private int y;

    Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Directions turnVertical() {
        switch (this) {
            case UP: return DOWN;
            case UPLEFT: return DOWNLEFT;
            case UPRIGHT: return DOWNRIGHT;
            case DOWN: return UP;
            case DOWNLEFT: return UPLEFT;
            case DOWNRIGHT: return UPRIGHT;
            default: return this;
        }
       // return Arrays.stream(values()).filter(directions -> directions.getY() == getY() * -1 && directions.getX() == getX()).findFirst().orElse(null);
    }

    public boolean isForward() {
        return this.equals(UP) || this.equals(UPLEFT) || this.equals(UPRIGHT);
    }

    public boolean isDiagonal() {
        return this.equals(UPLEFT) || this.equals(UPRIGHT) || this.equals(DOWNLEFT) || this.equals(DOWNRIGHT);
    }
}
