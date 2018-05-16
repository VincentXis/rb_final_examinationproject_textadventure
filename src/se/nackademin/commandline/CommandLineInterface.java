package se.nackademin.commandline;

public class CommandLineInterface implements CommandLineWriter{
    private String currentInputString;
    private CommandLineListener listener;

    public CommandLineInterface() {
        this.listener = new CommandLineListener(this);
    }

    public void requestUserInput() {
        currentInputString = listener.listen();
    }

    /**
     * Write to console, implemented from the interface commandlinewriter.
     * This method is also used by other classes when text is written to the console.
     */
    @Override
    public void write(String output) {
        System.out.println(output);
    }

    /**
     * this method is where other parts of the application to access what the user has written to the console.
     */
    public String getCurrentInputString() {
        if (currentInputString != null) {
            return currentInputString;
        } else {
            return "";
        }
    }

}
