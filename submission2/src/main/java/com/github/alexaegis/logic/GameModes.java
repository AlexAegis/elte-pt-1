package com.github.alexaegis.logic;

public enum GameModes {
    DASH(new DashLogic()),
    DASH_WITH_CHESS_PAWNS(new DashChessPawnLogic());

    private GameLogic gameLogic;

    GameModes(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    @Override
    public String toString() {
        switch(this) {
            case DASH:
                return "Dash";
            case DASH_WITH_CHESS_PAWNS:
                return "Dash (Chess pawns)";
            default:
                return "";
        }
    }
}