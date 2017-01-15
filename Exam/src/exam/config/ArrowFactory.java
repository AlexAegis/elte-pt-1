package exam.config;

import java.awt.*;

public final class ArrowFactory {

    private int paddingDivider = 10;
    private int thicknessDivider = 8;

    private static ArrowFactory instance;

    private ArrowFactory() {

    }

    public static ArrowFactory getFactory() {
        if (instance == null) {
            synchronized (ArrowFactory.class) {
                if (instance == null) {
                    instance = new ArrowFactory();
                }
            }
        }
        return instance;
    }

    public Polygon createDownArrow(int width, int height) {
        int padding = Math.min(width, height) / paddingDivider;
        int thickness = Math.min(width, height) / thicknessDivider;
        return createDownArrow(width, height, thickness, padding);
    }
    public Polygon createLeftArrow(int width, int height) {
        int padding = Math.min(width, height) / paddingDivider;
        int thickness = Math.min(width, height) / thicknessDivider;
        return createLeftArrow(width, height, thickness, padding);
    }
    public Polygon createUpArrow(int width, int height) {
        int padding = Math.min(width, height) / paddingDivider;
        int thickness = Math.min(width, height) / thicknessDivider;
        return createUpArrow(width, height, thickness, padding);
    }
    public Polygon createRightArrow(int width, int height) {
        int padding = Math.min(width, height) / paddingDivider;
        int thickness = Math.min(width, height) / thicknessDivider;
        return createRightArrow(width, height, thickness, padding);
    }

    public Polygon createDownArrow(int width, int height, int thickness, int padding) {
        Polygon downArrow = new Polygon();
        downArrow.addPoint((width / 2) - thickness, padding);
        downArrow.addPoint((width / 2) + thickness, padding);
        downArrow.addPoint((width / 2) + thickness, (height / 2) - thickness);
        downArrow.addPoint(width - padding, (height / 2) - thickness);
        downArrow.addPoint(width / 2, height - padding);
        downArrow.addPoint(padding, (height / 2) - thickness);
        downArrow.addPoint((width / 2) - thickness, (height / 2) - thickness);
        return downArrow;
    }

    public Polygon createLeftArrow(int width, int height, int thickness, int padding) {
        Polygon leftArrow = new Polygon();
        leftArrow.addPoint((width / 2) + thickness, padding);
        leftArrow.addPoint((width / 2) + thickness, (height / 2) - thickness);
        leftArrow.addPoint(width - padding, (height / 2) - thickness);
        leftArrow.addPoint(width - padding, (height / 2) + thickness);
        leftArrow.addPoint((width / 2) + thickness, (height / 2) + thickness);
        leftArrow.addPoint((width / 2) + thickness, height - padding);
        leftArrow.addPoint(padding, height / 2);
        return leftArrow;
    }

    public Polygon createUpArrow(int width, int height, int thickness, int padding) {
        Polygon upArrow = new Polygon();
        upArrow.addPoint(width - padding, (height / 2) + thickness);
        upArrow.addPoint((width / 2) + thickness, (height / 2) + thickness);
        upArrow.addPoint((width / 2) + thickness, height - padding);
        upArrow.addPoint((width / 2) - thickness, height - padding);
        upArrow.addPoint((width / 2) - thickness, (height / 2) + thickness);
        upArrow.addPoint(padding, (height / 2) + thickness);
        upArrow.addPoint(width / 2, padding);
        return upArrow;
    }

    public Polygon createRightArrow(int width, int height, int thickness, int padding) {
        Polygon rightArrow = new Polygon();
        rightArrow.addPoint((width / 2) - thickness, height - padding);
        rightArrow.addPoint((width / 2) - thickness, (height / 2) + thickness);
        rightArrow.addPoint(padding, (height / 2) + thickness);
        rightArrow.addPoint(padding, (height / 2) - thickness);
        rightArrow.addPoint((width / 2) - thickness, (height / 2) - thickness);
        rightArrow.addPoint((width / 2) - thickness, padding);
        rightArrow.addPoint(width - padding, height / 2);
        return rightArrow;
    }
}