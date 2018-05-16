package se.nackademin.theWawaAdventure;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.actions.Action;

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
            cli.askForInput();
            handleUserInput();
        }
        cli.write("Thank you for playing this... game?");
    }

    void handleUserInput() {
        if (cli.getCurrentInputString().isEmpty()) return;
        Action action;
        try {
            action = interpreter.getAction(cli.getCurrentInputString());
            cli.write(action.toString());
        } catch (Exception e) {
            cli.write("Invalid action, write help for more information");
        }
    }


}
