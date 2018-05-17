package se.nackademin.theWawaAdventure;

import se.nackademin.theWawaAdventure.actions.Action;

/**
 * This class is the interface between the game and the user what parses the input data and transforms that into something
 * the game can understand.
 */
public class InputInterpreter {
    private String userInput;
    private String[] inputData;


    /**
     * this is where the game gets the parsed user input in the form of an action that controls the game.
     */
    public Action getAction(String userInput) {
        handleInput(userInput);
        Action action = createAction();
        clean();
        return action;
    }

    /**
     * simply makes user input lowercase and splits the sting into an array wherever there's a space,
     * then initializes the member variables used in the class.
     */
    private void handleInput(String userInput) {
        this.userInput = userInput.toLowerCase();
        this.inputData = this.userInput.split(" ");
    }

    /**
     * creates an action depending on first word of each string the user inputs.
     * returns an "invalid" action of the number or arguments are wrong for the action or if the actions doesn't exist.
     */
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
                    return new Action.ActionBuilder(inputData[0]).argOne(inputData[1]).build();
                break;
            case "take":
                if (isValidLength(2))
                    return new Action.ActionBuilder(inputData[0]).argOne(inputData[1]).build();
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
            case "north":
                return true;
            case "south":
                return true;
            case "west":
                return true;
            case "east":
                return true;
            default:
                return false;
        }
    }

    /**
     * checks the length of the input data before building an action to avoid index out of bounds problems later.
     * eg. 'go north' has a length of 2 and would pass, when 'go' with a length of 1 would fail the test.
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
        String helpText = String.format("%s\n%s\n\t%s\n",
                "There are several actions you can do, the minimum amount of arguments needed after the action will be",
                "displayed to the left of the action and a description where needed. (the actions are not case sensitive)",
                "Valid actions are the following:");
        String commandInfo = String.format("\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s\n\t%d, %s\n",
                1, "go, eg. go north, go south etc.",
                1, "take, eg. 'take fork'",
                1, "drop, drop something in your inventory eg. drop hammer",
                3, "use, use an item on something in the room eg. 'use sword on troll' do not forget to write 'on'",
                0, "quit, quit the application",
                0, "help, shows this message ;)"
        );
        return String.format("%s%s", helpText, commandInfo);
    }

    private String quitMessage() {
        String smallDiv = "------------------------------------";
        return String.format("%s\n| %s |\n%s",
                smallDiv,
                "Thanks for playing this... game?",
                smallDiv
        );
    }

    private String invalidInputMessage() {
        return "Invalid input, cannot create an action from type help for more details: " + userInput;
    }
}
