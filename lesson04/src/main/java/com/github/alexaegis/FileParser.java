package com.github.alexaegis;

import com.github.alexaegis.vehicles.Car;
import com.github.alexaegis.vehicles.Vehicle;
import com.github.alexaegis.vehicles.VehicleFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

    public static List<Vehicle> parse(String fileName) throws FileNotFoundException { //TODO stub

        List<Vehicle> result = new ArrayList<>();

        try(Scanner scn = new Scanner(new File(fileName))) {
            while (scn.hasNextLine()) {
                Vehicle vehicle = parseVehicleFromString(scn.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    private static Vehicle parseVehicleFromString(String s) { //TODO stub
        Scanner scn = new Scanner(s);
        Vehicle vehicle = new ArrayList<Vehicle>().stream().filter(v -> v instanceof Car).max((v1, v2) -> {
            return v1.getFuelingsCount() - v2.getFuelingsCount();
        }).get();
        scn.close();
    }

}