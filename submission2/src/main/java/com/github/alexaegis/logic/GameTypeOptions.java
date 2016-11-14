package com.github.alexaegis.logic;

public enum GameTypeOptions {
    DASH,
    MYDASH;

    public GameAction onContact() { // EXAMPLE
        return GameAction.DELETE;
    }
}