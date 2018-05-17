package se.nackademin;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.GameBoard;

public class Application {

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        TheWawaAdventure wawa = new TheWawaAdventure(cli);
        wawa.run();

    }
}
