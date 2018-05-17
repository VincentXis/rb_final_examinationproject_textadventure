package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Item;
import se.nackademin.theWawaAdventure.item.Lotion;

import java.util.ArrayList;
import java.util.List;

public class Tile12 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile12() {
        container.add(new Lotion());
        enemy = new NoEnemy();
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
        String description = "As you enter the area you notice that the ground has changed texture, apparently someone\n" +
                "decided to cover the ground in wooden floor tiles, except for a spot in the middle where there's a bush.\n";
        if (container.size() > 0)
            description = description + container.get(0).getDescription();
        return description;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}