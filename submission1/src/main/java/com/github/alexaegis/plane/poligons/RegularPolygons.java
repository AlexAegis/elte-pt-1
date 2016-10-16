package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.poligons.exceptions.NoSuchPolygonException;

import java.util.Arrays;

public enum RegularPolygons {

    CIRCLE("Circle", 0),
    TRIANGLE("Triangle", 3),
    TETRAGON("Tetragon", 4),
    HEXAGON("Hexagon", 6);

    private String type;
    private int vertices;
    private double vertexAngle = 0d;

    RegularPolygons(String type, int vertices) {
        this.type = type;
        this.vertices = vertices;
        if(vertices > 0) {
            this.vertexAngle = 360d / vertices;
        }
    }

    public String getName() {
        return type;
    }

    public int getVertices() {
        return vertices;
    }

    public double getVertexAngle() {
        return vertexAngle;
    }

    public static boolean isPolygon(String type) {
        return Arrays.stream(RegularPolygons.values()).anyMatch(p -> p.getName().equals(type));
    }

    public static RegularPolygons getByName(String type) throws NoSuchPolygonException {
        return Arrays.stream(RegularPolygons.values())
                .filter(p -> p.getName().equals(type)).findFirst()
                .orElseThrow(() -> new NoSuchPolygonException("No polygon defined as " + type));
    }

}