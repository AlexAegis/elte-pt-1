package exam.config;

import exam.logic.games.*;
import exam.logic.abstraction.GameLogic;

public enum GameModes {
    NUMBER_GAME(new NumberGame()),
    DRAUGHT(new Draught()),
    DASH(new Dash()),
    MASTERMIND(new MasterMind()),
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