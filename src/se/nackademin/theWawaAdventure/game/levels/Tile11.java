package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile11 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile11() {
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
        return "as you enter the area the world is turned upside down. Your feet are still on the ground\n" +
                "but it feels like you could fall into the sky at any moment! better to get out of here before that happens.";
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
