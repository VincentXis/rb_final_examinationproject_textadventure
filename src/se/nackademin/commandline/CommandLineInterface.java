package se.nackademin.commandline;

public class CommandLineInterface implements CommandLineWriter{
    private String currentInputString;
    private CommandLineListener listener;

    public CommandLineInterface() {
        this.listener = new CommandLineListener(this);
    }

    public void askForInput() {
        currentInputString = listener.listen();
    }


    /**
     * Write to console
     * @param output - to the console
     */
    @Override
    public void write(String output) {
        System.out.println(output);
    }

    // Getters
    public String getCurrentInputString() {
        if (currentInputString != null) {
            return currentInputString;
        } else {
            return "";
        }
    }

}
