package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile13 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile13() {
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
        return "The air in this area makes your left earlobe feel warm... odd... ah well... there seems to be an owl nearby,\n" +
                "that's where the quacking is coming from. When you look up you see a cloud that looks like frog \n" +
                "wearing a shark fin as an owl barks in the distance.";
    }

    public Enemy getEnemy() {
        return enemy;
    }
}

