package se.nackademin.commandline;

import java.util.Scanner;

class CommandLineListener {
    private CommandLineInterface cli;

    CommandLineListener(CommandLineInterface cli) {
        this.cli = cli;
    }

    String listen() {
        return new Scanner(System.in).nextLine();
    }
}
