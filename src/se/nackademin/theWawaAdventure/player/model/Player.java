package se.nackademin.theWawaAdventure.player.model;

import se.nackademin.theWawaAdventure.inventory.model.Inventory;

import java.io.Serializable;
import java.util.UUID;


public class Player implements Serializable {
    private Inventory inventory;
    private UUID id;
    private String name;


    // Constructor
    private Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        inventory = new Inventory();
    }

    private Player(Inventory inventory, UUID id, String name) {
        this.inventory = inventory;
        this.id = id;
        this.name = name;
    }

    // getters
    public Inventory getInventory() {
        return inventory;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // setters
    private void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
