package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.item.Item;

public interface Level {
    Item getItem(String itemName);

    String getDescription();

    Enemy getEnemy();
}
