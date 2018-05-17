package se.nackademin.theWawaAdventure.actions;

import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.GameBoard;
import se.nackademin.theWawaAdventure.game.Position;

/**
 * This class takes an action and tries to execute it. It informs the game board if changes need to be made,
 * such as the move or use action.
 */
public class ActionHandler {
    private GameBoard gameBoard;
    private TheWawaAdventure wawaAdventure;

    public ActionHandler(TheWawaAdventure wawaAdventure) {
        this.wawaAdventure = wawaAdventure;
        this.gameBoard = wawaAdventure.getGameBoard();
    }

    /**
     * Takes the action created by the user and passes it along to the appropriate method.
     */
    public void executeAction(Action action) {
        switch (action.getType()) {
            case "go":
                moveAction(action);
                break;
            case "drop":
                dropAction(action);
                break;
            case "take":
                takeAction(action);
                break;
            case "use":
                useAction(action);
                break;
            case "help":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                break;
            case "quit":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                this.wawaAdventure.getGameBoard().setNewScene(true);
                this.wawaAdventure.quit();
                break;
        }
    }

    private void moveAction(Action action) {
        Position newPos = createPositionFromString(action.getArgOne());
        this.gameBoard.move(newPos);
    }

    private void dropAction(Action action) {
        this.gameBoard.dropItem(action.getArgOne());
    }

    private void takeAction(Action action) {
        this.gameBoard.takeItem(action.getArgOne());
    }

    private void useAction(Action action) {
        this.gameBoard.useItem(action.getArgOne(), action.getArgTwo());
    }

    /**
     * Creates a Position object with the value of the intended direction in relation to the current position
     */
    private Position createPositionFromString(String direction) {
        Position currentPosition = this.gameBoard.getCurrentPosition();
        switch (direction) {
            case "north":
                return new Position(currentPosition.getY() + 1, currentPosition.getX());
            case "south":
                return new Position(currentPosition.getY() - 1, currentPosition.getX());
            case "west":
                return new Position(currentPosition.getY(), currentPosition.getX() - 1);
            case "east":
                return new Position(currentPosition.getY(), currentPosition.getX() + 1);
        }
        return currentPosition;
    }

}
