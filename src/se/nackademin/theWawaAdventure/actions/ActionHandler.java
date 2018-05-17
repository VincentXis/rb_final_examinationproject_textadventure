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
                dropAction(action);
                break;
            case "take":
                takeAction(action);
                break;
            case "use":
                break;
            case "help":
                this.wawaAdventure.getView().writeMessage(action.getMessage());
                this.wawaAdventure.getGameBoard().setNewScene(true);
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
        this.gameBoard.dropItem(action.getArgOne());
    }

    private void takeAction(Action action) {
        this.gameBoard.takeItem(action.getArgOne());
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
