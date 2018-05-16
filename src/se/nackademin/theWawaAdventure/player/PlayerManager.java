package se.nackademin.theWawaAdventure.player;

import se.nackademin.theWawaAdventure.player.model.Player;

public class PlayerManager {
    public static Player createNewPlayer(String name) {
        return new Player();
    }
}
