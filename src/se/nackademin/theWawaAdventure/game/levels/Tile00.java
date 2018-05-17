package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Bazooka;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile00 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile00() {
        container.add(new Bazooka());
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
        String description = "You are in a small clearing the trees around you look scary and it's kind of chilly here \n" +
                "a wooden sign reads 'There's probably a treasure here somewhere'.\n";
        if (container.size() > 0)
            description = description + container.get(0).getDescription();
        return description;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
