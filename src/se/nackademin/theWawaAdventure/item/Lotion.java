package se.nackademin.theWawaAdventure.item;

public class Lotion implements Item {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Lotion";
    }

    @Override
    public String getDescription() {
        return "Under the bush you can see a half empty and rather dirty looking bottle fo lotion.";
    }

    @Override
    public String getPickupDescription() {
        return "There it is... the lotion you don't know why you want it... but you do! ALOT! (You're so weird) " +
                "\nYou pick up the bottle of lotion and put it in your front right pocket without hesitation.";
    }

    @Override
    public String getDropDescription() {
        return "You place the bottle of lotion on the ground, thinking 'You're not the boss of me' while looking away." +
                "\nthe bottle sobs slightly before it proceeds to sink into the abyss";
    }

    @Override
    public String getUseDescription(String target) {
        return "You take the bottle of lotion out of your front left trouser pocket and aim it at your target!\n" +
                "the " + target + " gasps!(if it can) " +
                "You sucker punch the bottle in the belly, a white streak of stuff escapes (probably lotion... I hope it is...)\n" +
                "Some of it gets on your hand! BUT YOU DON'T CARE! Yelling 'GET MOIST' at the " +target+" and punch it again";
    }

    @Override
    public String getUseSuccess(String target) {
        return "IT'S SUPER EFFECTIVE! the " + target + "is now well lubricated. #latheredup #slipperyhands";
    }

    @Override
    public String getUseFailure(String target) {
        return "You missed the " + target + "... What an embarrassment to your kind. Seems you imagined the white streak\n" +
                "in your excitement... the lid wasn't even open.... the " +target+ " sighs\n" +
                "(if it has lungs) if not it facepalms at you (if it has all the right bits for that gesture) ";
    }

    @Override
    public String toString() {
        return String.format("%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n", getId(), getName(), getDescription(), getPickupDescription(),
                getDropDescription(), getUseDescription("test"), getUseSuccess("test"), getUseFailure("test"));
    }
}
