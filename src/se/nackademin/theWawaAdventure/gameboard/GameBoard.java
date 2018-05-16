package se.nackademin.theWawaAdventure.gameboard;

import se.nackademin.theWawaAdventure.gameboard.levels.*;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    List<Level> tiles;

    public GameBoard() {
        tiles = new ArrayList<>();
    }

    public void printMap() {

    }

    public void createTiles() {
        Level tile00 = new Tile00();
        Level tile01 = new Tile01();
        Level tile02 = new Tile02();
        Level tile03 = new Tile03();
        Level tile10 = new Tile10();
        Level tile11 = new Tile11();
        Level tile12 = new Tile12();
        Level tile13 = new Tile13();


    }

}
