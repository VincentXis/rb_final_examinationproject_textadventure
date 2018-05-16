package se.nackademin.theWawaAdventure.actions;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.GameBoard;
import se.nackademin.theWawaAdventure.game.Position;

public class ActionHandler {
    private GameBoard gameBoard;
    private CommandLineInterface cli;
    private TheWawaAdventure wawaAdventure;

    public ActionHandler(TheWawaAdventure wawaAdventure) {
        this.wawaAdventure = wawaAdventure;
        this.gameBoard = wawaAdventure.getGameBoard();
    }


    public void executeAction(Action action) {
        switch (action.getType()) {
            case "go":
                moveAction(action);
                break;
            case "drop":
                break;
            case "take":
                break;
            case "use":
                break;
            case "help":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                break;
            case "quit":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                this.wawaAdventure.quit();
                break;
            case "reset":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                this.wawaAdventure.reset();
                break;
        }
    }

    private void moveAction(Action action) {
        Position newPos = createPositionFromString(action.getArgOne());
        this.gameBoard.movePlayer(newPos);
    }

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

    private void dropAction(Action action) {

    }

    private void takeAction(Action action) {

    }

    private void useAction(Action action) {

    }

    private void helpAction(Action action) {

    }

    private void quitAction(Action action) {

    }

    private void resetAction(Action action) {

    }
}
