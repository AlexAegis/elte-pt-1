package exam.config;

import exam.logic.games.Dash;
import exam.logic.abstraction.GameLogic;
import exam.logic.games.Draught;
import exam.logic.games.MasterMind;
import exam.logic.games.NumberGame;

public enum GameModes {
    NUMBER_GAME(new NumberGame()),
    DRAUGHT(new Draught()),
    DASH(new Dash()),
    MASTERMIND(new MasterMind()),
    DEBUGMODE(new NumberGame());

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