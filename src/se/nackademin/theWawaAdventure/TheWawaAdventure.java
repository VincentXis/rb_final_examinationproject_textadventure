package se.nackademin.theWawaAdventure;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.actions.Action;

/**
 * The main loop of the game is in this class and it pretty much is the nervous system where
 * instances are passed around etc.
 *
 */
public class TheWawaAdventure {
    private CommandLineInterface cli;
    private boolean runGame = true;
    private InputInterpreter interpreter = new InputInterpreter();
    public TheWawaAdventure(CommandLineInterface cli) {
        this.cli = cli;
    }

    public void run() {
        while (runGame) {
            cli.write("What would you like to do?");
            cli.requestUserInput();
            handleUserInput();
        }
        cli.write("Thank you for playing this... game?");
    }

    private void handleUserInput() {
        if (cli.getCurrentInputString().isEmpty()) return;
        Action action;
        try {
            action = interpreter.getAction(cli.getCurrentInputString());
            executeAction(action);
        } catch (Exception e) {
            cli.write("Unexpected error: " + e);
        }
    }

    private void executeAction(Action action) {
            cli.write(action.toString());
    }


}
