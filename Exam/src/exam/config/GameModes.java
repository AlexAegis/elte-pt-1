package exam.config;

import exam.logic.abstraction.GameLogic;
import exam.logic.NumberGameLogic;

public enum GameModes {
    NUMBER_GAME(new NumberGameLogic()),
    DEBUGMODE(new NumberGameLogic());

    private GameLogic gameLogic;

    GameModes(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogic getLogic() {
        return gameLogic;
    }

    @Override
    public String toString() {
        return gameLogic.toString();
    }
}