package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.Squirrel;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile03 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile03() {
        enemy = new Squirrel();
    }

    @Override
    public Item getItem(String itemName) {
        if (container.size() > 0) {
            if (container.get(0).getName().equalsIgnoreCase(itemName)) {
                return container.remove(0);
            }
        }
        return null;
    }

    @Override
    public String getDescription() {
        String description = "This area looks more or less the same as the rest of the forest, massive trees bushes everywhere.\n" +
                "All the same really except... except for... ";
        if (getEnemy().isAlive())
            description = description + getEnemy().getDescription();
        else
            description = description + getEnemy().enemyDefeatedMessage();
        return description;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}

