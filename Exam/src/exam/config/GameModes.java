package exam.config;

import exam.logic.games.*;
import exam.logic.abstraction.GameLogic;

public enum GameModes {
    KNIGHTSTOUR(new KnightsTour()),
    MASTERMIND(new MasterMind()),
    NUMBER_GAME(new NumberGame()),
    DASH(new Dash()),
    EMPTY(new Empty());

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