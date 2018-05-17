package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.enemy.NoEnemy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Tile02 implements Level {
    private List<Item> container = new ArrayList<>();
    private Enemy enemy;

    public Tile02() {
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
        return "There is a glowing circle in this room and the air around you energizes your body.\n" +
                "A small leather wallet is lying in the middle of the room, you pick it up from the ground.\n" +
                "'This is it! I'M RICH!!!' you yell in excitement. Looking around the room you realize that \n" +
                "there's a massive parking lot to the south and even better! A McDonald's! You enter the 'restaurant'\n" +
                "and spend your riches on ten cheeseburgers and a diet coke (got to watch that figure)\n" +
                "Well fed and poor people again you go home and never think of this again.";
    }

    public Enemy getEnemy() {
        return enemy;
    }
}