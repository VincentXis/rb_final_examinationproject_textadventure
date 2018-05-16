package se.nackademin.theWawaAdventure.game;

import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.levels.*;
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
    private boolean updateScene = false;
    private View view;

    public GameBoard(TheWawaAdventure wawaAdventure) {
        setupGameBoard();
        currentPosition = new Position(0, 0);
        previousPosition = currentPosition;
        currentLevel = getWorldMap().get(currentPosition);
        player = new Player();
        this.view = wawaAdventure.getView();
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

    public Player getPlayer() {
        return player;
    }

    public Map<Position, Level> getWorldMap() {
        return worldMap;
    }

    public Map<Level, List<Position>> getConnectedTiles() {
        return connectedTiles;
    }

    public void movePlayer(Position newPos) {
        List<Position> possibleMoves = this.getConnectedTiles().get(this.currentLevel);
        for (Position possibleMove : possibleMoves) {
            if (possibleMove.equals(newPos)) {
                this.previousPosition = this.currentPosition;
                this.currentPosition = newPos;
                return;
            }
        }
        this.view.writeMessage("You walked into a tree...");
    }

    public List<String> possibleDirections() {
        List<String> possibleDirections = new ArrayList<>();
        for (Position connectedTile : getConnectedTiles().get(currentLevel)) {
            if (connectedTile.getY() > this.getCurrentPosition().getY())
                possibleDirections.add("north");
            if (connectedTile.getY() < this.getCurrentPosition().getY())
                possibleDirections.add("south");
            if (connectedTile.getX() > this.getCurrentPosition().getX())
                possibleDirections.add("east");
            if (connectedTile.getX() < this.getCurrentPosition().getX())
                possibleDirections.add("west");
        }
        return possibleDirections;
    }
}
