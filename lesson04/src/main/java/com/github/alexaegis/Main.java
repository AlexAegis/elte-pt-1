package com.github.alexaegis;

import com.github.alexaegis.vehicles.Vehicle;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Vehicle> vehicleList = FileParser.parse("src/main/resources/input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}