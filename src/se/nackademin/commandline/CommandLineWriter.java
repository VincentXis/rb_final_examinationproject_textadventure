package se.nackademin.commandline;

/**
 * Interface used by the class commandLineInterface to limit access to the class from outside uses.
 * The reason why is so that ANYTHING printed to the console has to come through this function thus makes it easier
 * to find problems with the output. (IMO)
 */
public interface CommandLineWriter {
    void write(String output);
}
