package se.nackademin;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.TheWawaAdventure;

public class Application {

    public static void main(String[] args) {
        System.out.println("MAIN!");
        CommandLineInterface cli = new CommandLineInterface();
        new TheWawaAdventure(cli).run();
    }
}
