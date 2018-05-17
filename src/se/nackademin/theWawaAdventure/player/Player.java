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
            return "empty";
        StringBuilder sb = new StringBuilder();
        for (Item item : inventory.getItems()) {
            sb.append(item.getName());
            sb.append(", ");
        }
        return sb.toString();
    }

    public String die() {
        isAlive = false;
        return "You died... hard... game over... lol... wawa";
    }

    public Item useItem(String itemName) {
        return inventory.useItem(itemName);
    }

    public String dropItem(String item) {
        return inventory.dropItem(item);
    }

    public void takeItem(Item item) {
        inventory.addItem(item);
    }

    public boolean isAlive() {
        return isAlive;
    }
}
