package se.nackademin.theWawaAdventure.game.levels;

/**
 * Takes a level object and returns the description string, instead of using a toString override.
 */
public class LevelDrawer {
    public String drawLevel(Level level) {
        return level.getDescription();
    }
}
