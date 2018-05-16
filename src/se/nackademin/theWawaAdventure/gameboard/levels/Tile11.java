package se.nackademin.theWawaAdventure.gameboard.levels;

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
    public List<Item> getContainer() {
        return container;
    }

    @Override
    public String getDescription() {
        String description = "You wake up in a forest, its kind of chilly and you dont know why you are here\n";
        if (container.size() >0)
            description = description + container.get(0).getDescription();
        return description;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
