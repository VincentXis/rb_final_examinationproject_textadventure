package se.nackademin.theWawaAdventure.enemy;

public class NoEnemy implements Enemy {
    @Override
    public String getType() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String weakAgainst() {
        return "";
    }

    @Override
    public String die() {
        return "";
    }

    @Override
    public String attack() {
        return "";
    }
}
