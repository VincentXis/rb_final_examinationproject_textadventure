package se.nackademin.theWawaAdventure;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.actions.Action;
import se.nackademin.theWawaAdventure.actions.ActionHandler;
import se.nackademin.theWawaAdventure.game.GameBoard;
import se.nackademin.theWawaAdventure.game.Position;
import se.nackademin.theWawaAdventure.game.View;

/**
 * The main loop of the game is in this class and it pretty much is the nervous system where
 * instances are passed around etc.
 */
public class TheWawaAdventure {
    private CommandLineInterface cli;
    private boolean runGame = true;
    private InputInterpreter interpreter = new InputInterpreter();
    private ActionHandler actionHandler;
    private GameBoard gameBoard;
    private View view;

    public TheWawaAdventure(CommandLineInterface cli) {
        this.cli = cli;
        this.gameBoard = new GameBoard();
        this.view = new View(this);
        this.gameBoard.setView(this.view);
        this.actionHandler = new ActionHandler(this);

    }

    /**
     * This is the main loop that keeps the game alive until the console is shut down or until the user writes quit.
     * prevents the scene from being rendered every time the the user writes something. instead it waits until instructed to rerender.
     */
    public void run() {
        while (runGame) {
            view.describeScene(gameBoard.getCurrentLevel());
            gameBoard.setNewScene(false);
            while (!gameBoard.isNewScene()) {
                cli.requestUserInput();
                handleUserInput();
            }

            if (this.gameBoard.getCurrentPosition().equals(new Position(0, 2))) {
                view.writeMessage("that's it... what did you expect?");
            }
        }
    }

    /**
     * sends the action to be handled by the game.
     */
    private void handleUserInput() {
        if (cli.getCurrentInputString().isEmpty()) return;
        Action action;
        try {
            action = interpreter.getAction(cli.getCurrentInputString());
            actionHandler.executeAction(action);

        } catch (Exception e) {
            cli.write("Unexpected error: " + e);
        }
    }

    /**
     * Allows run() to exit the outer while loop, thus allowing the application run the remaining code and then shut down correctly.
     */
    public void quit() {
        this.runGame = false;
    }

    // Getters
    public View getView() {
        return view;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public CommandLineInterface getCli() {
        return cli;
    }
}
