package com.github.alexaegis.logic;

public enum GameType {
    DASH,
    MYDASH;

    public GameAction onContact() { // EXAMPLE
        return GameAction.DELETE;
    }
}