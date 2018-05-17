package se.nackademin.theWawaAdventure.player;

import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public String dropItem(String itemName) {
        boolean itemRemoved = false;
        String itemDropMessage = "";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemDropMessage = item.getDropDescription();
                items.remove(item);
                itemRemoved = true;
            }
        }
        if (itemRemoved) return itemDropMessage;
        else return "no such item in your inventory";
    }

    public Item useItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }
}
