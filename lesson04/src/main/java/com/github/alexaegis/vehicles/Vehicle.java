package com.github.alexaegis.vehicles;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    protected String id;
    protected List<Integer> fuelings = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getFuelings() {
        return fuelings;
    }

    public void setFuelings(List<Integer> fuelings) {
        this.fuelings = fuelings;
    }
}