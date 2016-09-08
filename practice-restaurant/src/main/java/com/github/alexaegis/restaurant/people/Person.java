package com.github.alexaegis.restaurant.people;

public abstract class Person {

    String name;

    Person() {

    }

    Person(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}