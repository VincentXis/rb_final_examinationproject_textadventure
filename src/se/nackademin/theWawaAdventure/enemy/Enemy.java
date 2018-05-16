package se.nackademin.theWawaAdventure.enemy;

public interface Enemy {
    String getType();

    String getDescription();

    boolean isAlive();

    String weakAgainst();

    String die();

    String attack();
}
