package se.nackademin.theWawaAdventure;

import se.nackademin.theWawaAdventure.actions.Action;

public class InputInterpreter {
    private String userInput;
    private String[] inputData;

    // getter
    public Action getAction(String userInput) {

        handleInput(userInput);
        Action action = createAction();
        clean();
        return action;
    }

    private void handleInput(String userInput) {
        this.userInput = userInput.toLowerCase();
        inputData = this.userInput.split(" ");
    }

    private Action createAction() {
        switch (inputData[0]) {
            case "go":
                if (isValidLength(2) && isValidDirection())
                    return new Action.ActionBuilder(inputData[0])
                            .argOne(inputData[1])
                            .build();
                break;
            case "drop":
                if (isValidLength(2))
                    return new Action.ActionBuilder(inputData[0]).argTwo(inputData[1]).build();
                break;
            case "use":
                if (isValidLength(4) && isValidModifier())
                    return new Action.ActionBuilder(inputData[0])
                            .argOne(inputData[1])
                            .argTwo(inputData[3])
                            .build();
                break;
            case "help":
                return new Action.ActionBuilder(inputData[0])
                        .message(helpMessage())
                        .build();
            case "quit":
                return new Action.ActionBuilder(inputData[0])
                        .message(quitMessage())
                        .build();
            case "restart":
                return new Action.ActionBuilder(inputData[0])
                        .message(restartMessage())
                        .build();
        }
        return new Action.ActionBuilder("invalid")
                .message(invalidInputMessage())
                .build();
    }

    /**
     * resets the userInput and inputData variables just in case they would vause a problem somewhere
     */
    private void clean() {
        this.userInput = null;
        this.inputData = null;
    }

    /**
     * check that the passed argument after the action type go is an actual direction.
     */
    private boolean isValidDirection() {
        switch (inputData[1].toLowerCase()) {
            case "forward":
                return true;
            case "back":
                return true;
            case "left":
                return true;
            case "right":
                return true;
            default:
                return false;
        }
    }

    /**
     * checks the length of the input data before building an action to avoid index out of bounds problems later.
     * eg. 'go forward' has a length of 2 and would pass, when 'go' with a length of 1 would fail the test.
     */
    private boolean isValidLength(int minLength) {
        return inputData.length >= minLength;
    }

    /**
     * checks if the 3rd word in the array is the word 'on' because that is.
     */
    private boolean isValidModifier() {
        return inputData[2].equals("on");
    }

    // Messages that are added to the zero argument actions.
    private String helpMessage() {
        return String.format(
                "There are several actions you can do, " +
                        "the minimum amount of arguments needed after the action will be displayed to " +
                        "the left of the action and a description where needed. " +
                        "(the actions are not case sensitive)\n" +
                        "\tValid actions are the following:\n\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s",
                1, "go, eg. go forward, go back etc.",
                1, "drop, drop something in your inventory eg. drop hammer",
                3, "use, use an item on something in the room eg. 'use sword on troll' or 'use torch on bush' do not forget to write 'on'",
                0, "quit, quit the application",
                0, "restart, restart the game (restarts the session, loosing all progress)",
                0, "help, shows this message ;)"
        );
    }

    private String restartMessage() {
        return "\n\n\n\n\n\n\n\n\tStarting a new session.";
    }

    private String quitMessage() {
        return "\n\tThanks for playing this... game?";
    }

    private String invalidInputMessage() {
        return "\tInvalid input, cannot create an action from type help for more details: " + userInput;
    }
}
