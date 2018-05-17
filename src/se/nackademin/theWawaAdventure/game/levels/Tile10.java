package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile10 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile10() {
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
        return "The trees in this are are massive, there doesn't seem to be anything here. You feel hungry and like poor people,\n" +
                "to bad that you didn't eat before coming into the forest... (dummy)";
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
