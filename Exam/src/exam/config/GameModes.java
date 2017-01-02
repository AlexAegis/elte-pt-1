package exam.config;

import exam.logic.GameLogic;
import exam.logic.NumberGameLogic;

public enum GameModes {
    NUMBER_GAME(new NumberGameLogic());

    GameLogic gameLogic;

    GameModes(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogic getLogic() {
        return gameLogic;
    }
}
