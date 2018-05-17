package se.nackademin.theWawaAdventure.game;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.game.levels.GameBoardUtil;
import se.nackademin.theWawaAdventure.game.levels.Level;
import se.nackademin.theWawaAdventure.item.Item;
import se.nackademin.theWawaAdventure.player.Player;

import java.util.List;
import java.util.Map;

/**
 * This is the game board, it holds the player and the world map. TheWawaAdventureClass makes everything work, but this
 * is where the actual game lives, where changes are made etc.
 */
public class GameBoard {
    private GameBoardUtil util = new GameBoardUtil();
    private Map<Position, Level> worldMap = util.getWorldMap();
    private Map<Level, List<Position>> connectedTiles = util.getConnectedTiles();

    private Position previousPosition;
    private Position currentPosition;
    private Level currentLevel;

    private boolean newScene = false;
    private View view;

    private Player player;

    public GameBoard() {
        currentPosition = new Position(0, 0);
        previousPosition = currentPosition;
        currentLevel = getWorldMap().get(currentPosition);
        player = new Player();
    }

    // Setters
    public void setView(View view) {
        this.view = view;
    }

    public void setNewScene(boolean newScene) {
        this.newScene = newScene;
    }

    // Getters
    public GameBoardUtil getUtil() {
        return util;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

    private Map<Position, Level> getWorldMap() {
        return worldMap;
    }

    public Map<Level, List<Position>> getConnectedTiles() {
        return connectedTiles;
    }

    public boolean isNewScene() {
        return newScene;
    }

    // Game related actions
    /**
     * Takes a position and moves to the new position if possible this is the navigation system.
     */
    public void move(Position newPosition) {
        List<Position> possibleMoves = this.getConnectedTiles().get(this.currentLevel);
        if (this.currentLevel.getEnemy().isAlive()) {
            this.view.writeMessage("other directions are obscured you can only go back " +
                    util.positionToDirectionString(previousPosition, this) +
                    " unless the enemy is defeated"
            );
            if (this.previousPosition.equals(newPosition))
                changeSceneAndUpdatePosition(newPosition);
            return;
        }
        for (Position possibleMove : possibleMoves) {
            if (possibleMove.equals(newPosition)) {
                changeSceneAndUpdatePosition(newPosition);
                return;
            }
        }
        this.view.writeMessage("You walked into a tree...");
    }


    public void dropItem(String item) {
        this.view.writeMessage(getPlayer().dropItem(item));
    }

    public void takeItem(String itemName) {
        Item item = this.currentLevel.getItem(itemName);
        if (item != null) {
            this.view.writeMessage("You pickup the " + item.getPickupDescription());
            getPlayer().takeItem(item);
        } else {
            this.view.writeMessage("There is no such item here.");
        }
    }

    /**
     * Implementation of a use action and is basically a combat mechanic
     * It checks:
     * if the queried item is in the players inventory, if an enemy is alive on the current tile,
     * if everything checks out the players item and the enemy is passed to the combat system to resolve the outcome.
     * <p>
     * Messages of the possible outcomes are passed to the View class and written to the console when appropriate
     * <p>
     * For now this is the only fail state mechanic in the game.
     */
    public void useItem(String itemName, String target) {
        Item item = getPlayer().useItem(itemName);
        Enemy enemy = getCurrentLevel().getEnemy();

        if (item != null) {
            if (enemy.isAlive()) {
                if (enemy.getType().equalsIgnoreCase(target)) {
                    CombatSystem combatSystem = new CombatSystem(item, enemy);
                    combatSystem.getFightScene().forEach(scene -> this.view.writeMessage(scene));
                    if (combatSystem.isEnemyDefeated()) {
                        this.view.writeMessage(getCurrentLevel().getEnemy().die());
                        this.view.writeMessage("\n" + player.dropItem(itemName));

                        return;
                    } else {
                        this.view.writeMessage(player.die());
                        return;
                    }
                }
                this.view.writeMessage("There is no " + target + " in this area");
                return;
            }
            this.view.writeMessage("There is no target");
            return;
        }
        this.view.writeMessage("You don't have: " + itemName + " in your inventory");
    }

    /**
     * Updates the current and previous position after a move action and informs the Game loop that
     * a new scene should be drawn in the console.
     */
    private void changeSceneAndUpdatePosition(Position newPosition) {
        this.previousPosition = this.currentPosition;
        this.currentPosition = newPosition;
        this.currentLevel = getWorldMap().get(currentPosition);
        this.newScene = true;
    }

}
