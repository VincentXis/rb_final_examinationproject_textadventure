package se.nackademin.theWawaAdventure.game.levels;

import se.nackademin.theWawaAdventure.game.GameBoard;
import se.nackademin.theWawaAdventure.game.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class fro the GameBoard class
 */
public class GameBoardUtil {
    private Map<Position, Level> worldMap;
    private Map<Level, List<Position>> connectedTiles;
    /**
     * Sets up the game board and maps connected positions for each tile,
     * not the cleanest way to do this but it is effective.
     * This is done here in this utility class to remove visual noise from the GameBoard class.
     */
    public GameBoardUtil() {
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
        connectedTiles.put(tile10, List.of(pos00, pos11));
        connectedTiles.put(tile11, List.of(pos01, pos10, pos12));
        connectedTiles.put(tile12, List.of(pos11, pos13));
        connectedTiles.put(tile13, List.of(pos03, pos12));
    }

    // Getters
    public Map<Position, Level> getWorldMap() {
        return worldMap;
    }

    public Map<Level, List<Position>> getConnectedTiles() {
        return connectedTiles;
    }

    /**
     * Returns the direction of another position in relation to the current position
     */
    public String positionToDirectionString(Position otherPosition, GameBoard gameBoard) {
        if (otherPosition.getY() > gameBoard.getCurrentPosition().getY())
            return "north";
        else if (otherPosition.getY() < gameBoard.getCurrentPosition().getY())
            return "south";
        else if (otherPosition.getX() > gameBoard.getCurrentPosition().getX())
            return "east";
        else
            return "west";
    }

    /**
     * Creates the string value of the connected tiles based on their coordinates
     * used to display which directions the user can move
     */
    public List<String> possibleDirectionStrings(GameBoard gameBoard) {
        List<String> possibleDirections = new ArrayList<>();
        for (Position connectedTile : gameBoard.getConnectedTiles().get(gameBoard.getCurrentLevel())) {
            possibleDirections.add(positionToDirectionString(connectedTile, gameBoard));
        }
        return possibleDirections;
    }
}
