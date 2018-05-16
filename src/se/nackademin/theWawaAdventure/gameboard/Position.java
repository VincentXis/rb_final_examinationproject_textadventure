package se.nackademin.theWawaAdventure.gameboard;

import java.util.List;

public class Position {
    private List<Position> connectedPositions;
    private int y;
    private int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
