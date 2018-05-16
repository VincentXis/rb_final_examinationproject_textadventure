package se.nackademin.theWawaAdventure.game;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getY() == position.getY() &&
                getX() == position.getX() &&
                Objects.equals(connectedPositions, position.connectedPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectedPositions, getY(), getX());
    }

    @Override
    public String toString() {
        return String.format("pos: %d,%d", getY(), getX());
    }
}
