package se.nackademin.theWawaAdventure.player;

import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public String addItem(Item item) {
        items.add(item);
        return item.getPickupDescription();
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
    public String useItem(String itemName, String target) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName))
                return item.getUseDescription(target);
        }
        return "This item is not in your inventory dude";
    }

    public List<Item> getItems() {
        return items;
    }
}
