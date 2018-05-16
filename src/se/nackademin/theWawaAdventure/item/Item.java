package se.nackademin.theWawaAdventure.item;


/**
 * Common interface for all items in the game.
 * allows all classes that implement this interface to be stored in a 'container' such as a box or the inventory
 */
public interface Item {
    int getId();

    String getName();

    String getDescription();

    String getPickupDescription();

    String getDropDescription();

    String getUseDescription(String target);

    String getUseSuccess(String target);

    String getUseFailure(String target);
}
