package se.nackademin.commandline;

import java.util.Scanner;

class CommandLineListener {
    /**
     * simply listens for the next line the user inputs to the console.
     */
    String listen() {
        return new Scanner(System.in).nextLine();
    }
}
