package se.nackademin.theWawaAdventure.actions;

/**
 * Actions are created from parsed user input data, the message field is to display information when something is wrong,
 * the type determines what should be done, eg. quit or walk forward.
 * argOne is the second word written by the user IF it exists and argTwo is the 4th word.
 * the only action that requires 2 args is the 'use' action and the
 * format is: 'use hammer(argOne) on troll(argTwo)' the word on is required but the 2nd and 4th word are what the action
 * is about.
 */
public class Action {
    private final String type;
    private final String argOne;
    private final String argTwo;
    private final String message;

    private Action(ActionBuilder builder) {
        this.type = builder.type;
        this.argOne = builder.argOne;
        this.argTwo = builder.argTwo;
        this.message = builder.message;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getArgOne() {
        return argOne;
    }

    public String getArgTwo() {
        return argTwo;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Builder class for action, does nothing except create a new action instance.
     */
    public static class ActionBuilder {
        private String type;
        private String argOne;
        private String argTwo;
        private String message;

        public ActionBuilder(String actionType) {
            this.type = actionType;
            argOne = "";
            argTwo = "";
            message = "";
        }

        public ActionBuilder argOne(String firstArg) {
            this.argOne = firstArg;
            return this;
        }

        public ActionBuilder argTwo(String secondArg) {
            this.argTwo = secondArg;
            return this;
        }

        public ActionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public Action build() {
            return new Action(this);
        }
    }

    /**
     * only used in developement, returns a string of the member variables of the class.
     */
    @Override
    public String toString() {
        return String.format("Type: %s\nargOne: %s\nargTwo: %s\nmessage: %s",
                type, argOne, argTwo, message);
    }
}
