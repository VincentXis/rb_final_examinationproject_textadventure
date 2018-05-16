package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.item.Item;

import java.util.List;

public interface Level {
    List<Item> getContainer();

    String getDescription();
}
