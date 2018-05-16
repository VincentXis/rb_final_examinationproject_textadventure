package se.nackademin.theWawaAdventure;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.actions.Action;
import se.nackademin.theWawaAdventure.actions.ActionHandler;
import se.nackademin.theWawaAdventure.game.GameBoard;
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
        this.view = new View(this);
        this.actionHandler = new ActionHandler(this);
        this.gameBoard = new GameBoard(this);

    }

    public void run() {
        while (runGame) {
            cli.write("What would you like to do?");
            cli.requestUserInput();
            handleUserInput();
        }
    }

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

    public void reset() {
        this.gameBoard = new GameBoard(this);
    }

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
