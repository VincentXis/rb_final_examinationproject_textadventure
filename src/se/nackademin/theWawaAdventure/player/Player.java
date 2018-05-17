package se.nackademin.theWawaAdventure.player;

import se.nackademin.theWawaAdventure.item.Item;

public class Player {
    private boolean isAlive;
    private Inventory inventory;

    public Player() {
        isAlive = true;
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String showInventory() {
        if (inventory.getItems().size() == 0)
            return "your inventory is empty";
        StringBuilder sb = new StringBuilder();
        for (Item item : inventory.getItems()) {
            sb.append(item.getName());
        }
        return sb.toString();
    }

    public String die() {
        isAlive = false;
        return "You died... hard... lol";
    }

    public String useItem(String item, String target) {
        return inventory.useItem(item, target);
    }

    public String  dropItem(String item) {
        return inventory.dropItem(item);
    }

    public String takeItem(Item item) {
        return inventory.addItem(item);
    }

}
