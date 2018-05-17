package se.nackademin.theWawaAdventure.item;

public class Bazooka implements Item {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "Bazooka";
    }

    @Override
    public String getDescription() {
        return "On the ground you can see an innocent looking Bazooka with a single rocket beside it. " +
                "\nThe rocket has a picture of a cat on it...";
    }

    @Override
    public String getPickupDescription() {
        return "Bazooka and say 'this could come in handy, I have to mind when I use it though... " +
                "\nRockets are rare in this part of the world.' " +
                "\nThe weapon now resides the left back pocket of your trousers, which is impressive since " +
                "\nthey don't look like they would fit a bazooka in there. Seems that pocket is larger on the inside.";
    }

    @Override
    public String getDropDescription() {
        return "You drop your bazooka, and yet again you start talking to yourself 'farewell old friend I will avenge you' " +
                "\n\t(why would you avenge a bazooka? You're weird...)";
    }

    @Override
    public String getUseDescription(String target) {
        return "You smile in the face of(if it has one... you never know) your enemy the '" + target +
                "' and fire a rocket \nstraight in said face(again if it has one... AND!";
    }

    @Override
    public String getUseSuccess(String target) {
        return "Absolutely nothing remains of your target especially not the face (if it had one), \nthe " + target +
                " was completely obliterated. #noscope";
    }

    @Override
    public String getUseFailure(String target) {
        return "ABSOLUTELY nothing happened, what a waste of ammo. (stupid move if you ask me...)";
    }

    @Override
    public String toString() {
        return String.format("%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n", getId(), getName(), getDescription(), getPickupDescription(),
                getDropDescription(), getUseDescription("test"), getUseSuccess("test"), getUseFailure("test"));
    }
}
