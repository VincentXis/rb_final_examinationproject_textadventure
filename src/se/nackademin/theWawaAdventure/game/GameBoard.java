package se.nackademin.theWawaAdventure.game;

import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.levels.*;
import se.nackademin.theWawaAdventure.item.Item;
import se.nackademin.theWawaAdventure.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
    private Position previousPosition;
    private Position currentPosition;
    private Level currentLevel;
    private Player player;
    private Map<Position, Level> worldMap;
    private Map<Level, List<Position>> connectedTiles;
    private boolean newScene = false;
    private View view;

    public GameBoard() {
        setupGameBoard();
        currentPosition = new Position(0, 0);
        previousPosition = currentPosition;
        currentLevel = getWorldMap().get(currentPosition);
        player = new Player();
    }

    public void setView(View view) {
        this.view = view;
    }


    /**
     * Sets up the game board and maps connected positions for each tile
     */
    private void setupGameBoard() {
        worldMap = new HashMap<>();
        connectedTiles = new HashMap<>();

        Position pos00 = new Position(0, 0);
        Position pos01 = new Position(0, 1);
        Position pos02 = new Position(0, 2);
        Position pos03 = new Position(0, 3);
        Position pos10 = new Position(1, 0);
        Position pos11 = new Position(1, 1);
        Position pos12 = new Position(1, 2);
        Position pos13 = new Position(1, 3);

        Level tile00 = new Tile00();
        Level tile01 = new Tile01();
        Level tile02 = new Tile02();
        Level tile03 = new Tile03();
        Level tile10 = new Tile10();
        Level tile11 = new Tile11();
        Level tile12 = new Tile12();
        Level tile13 = new Tile13();

        worldMap.put(pos00, tile00);
        worldMap.put(pos01, tile01);
        worldMap.put(pos02, tile02);
        worldMap.put(pos03, tile03);
        worldMap.put(pos10, tile10);
        worldMap.put(pos11, tile11);
        worldMap.put(pos12, tile12);
        worldMap.put(pos13, tile13);

        connectedTiles.put(tile00, List.of(pos10));
        connectedTiles.put(tile01, List.of(pos02, pos11));
        connectedTiles.put(tile02, List.of(pos01, pos03));
        connectedTiles.put(tile03, List.of(pos02, pos13));
        connectedTiles.put(tile10, List.of(pos01, pos11));
        connectedTiles.put(tile11, List.of(pos01, pos10, pos12));
        connectedTiles.put(tile12, List.of(pos11, pos13));
        connectedTiles.put(tile13, List.of(pos03, pos12));
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

    public Map<Position, Level> getWorldMap() {
        return worldMap;
    }

    public Map<Level, List<Position>> getConnectedTiles() {
        return connectedTiles;
    }

    public boolean isNewScene() {
        return newScene;
    }

    public void setNewScene(boolean newScene) {
        this.newScene = newScene;
    }

    public void move(Position newPosition) {
        List<Position> possibleMoves = this.getConnectedTiles().get(this.currentLevel);
        if (this.currentLevel.getEnemy().isAlive()) {
            this.view.writeMessage("other directions are obscured you can only go back " +
                    positionToDirectionString(previousPosition) +
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
    private void changeSceneAndUpdatePosition(Position newPosition) {
        this.previousPosition = this.currentPosition;
        this.currentPosition = newPosition;
        this.currentLevel = getWorldMap().get(currentPosition);
        this.newScene = true;
    }
    public List<String> possibleDirections() {
        List<String> possibleDirections = new ArrayList<>();
        for (Position connectedTile : getConnectedTiles().get(currentLevel)) {
            possibleDirections.add(positionToDirectionString(connectedTile));
        }
        return possibleDirections;
    }

    private String positionToDirectionString(Position otherPosition) {
        if (otherPosition.getY() > this.getCurrentPosition().getY())
            return "north";
        else if (otherPosition.getY() < this.getCurrentPosition().getY())
            return "south";
        else if (otherPosition.getX() > this.getCurrentPosition().getX())
            return "east";
        else
            return "west";
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
}
