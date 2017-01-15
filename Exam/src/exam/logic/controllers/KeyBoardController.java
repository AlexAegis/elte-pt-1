package exam.logic.controllers;

import exam.elements.tiles.Tile;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.abstraction.GameLogic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

import static exam.elements.panels.Menu.STEPCOUNTER;

public class KeyBoardController implements KeyListener {

    private GameLogic gameLogic = null;
    private boolean enabled = false;

    public KeyBoardController( ) {

    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        gameLogic = null;
        enabled = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(enabled && gameLogic != null) {
            Optional<Directions> direction = Optional.empty();
            if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                direction = Optional.of(Directions.DOWN);
            } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                direction = Optional.of(Directions.RIGHT);
            } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                direction = Optional.of(Directions.UP);
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                direction = Optional.of(Directions.LEFT);
            }
            if(gameLogic.getActualPawn() != null && direction.isPresent()) {
                Coordinate to = ((Tile)gameLogic.getActualPawn().getParent()).getCoordinate().stepInDirection(direction.get());
                if(gameLogic.getGrid().getTiles().containsKey(to)) {
                    gameLogic.evaluateStep((Tile) gameLogic.getActualPawn().getParent(), gameLogic.getGrid().getTiles().get(to));
                    STEPCOUNTER.increase();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}