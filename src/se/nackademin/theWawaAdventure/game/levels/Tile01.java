package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.Mummy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile01 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile01() {
        enemy = new Mummy();
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
        String description = "You can see something that looks like an old sacrificial altar at least that's what you think it is.\n";
        if (container.size() > 0)
            description = description + container.get(0).getDescription();
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
