package se.nackademin.theWawaAdventure.actions;

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

    // builder
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
     * only used in developement
     */
    @Override
    public String toString() {
        return String.format("Type: %s\nargOne: %s\nargTwo: %s\nmessage: %s",
                type, argOne, argTwo, message);
    }
}
