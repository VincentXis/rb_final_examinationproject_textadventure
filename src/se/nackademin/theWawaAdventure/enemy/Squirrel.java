package se.nackademin.theWawaAdventure.enemy;

public class Squirrel implements Enemy {
    private boolean isAlive;

    public Squirrel() {
        this.isAlive = true;
    }

    @Override
    public String getType() {
        return "Squirrel";
    }

    @Override
    public String getDescription() {
        return "a MEAN looking squirrel with a knife";
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String weakAgainst() {
        return "Bazooka";
    }

    @Override
    public String die() {
        isAlive = false;
        return "the squirrel is no more, it's mega dead!. the knife leaves for a extended vacation.";
    }

    @Override
    public String attack() {
        return "The Squirrel stabs you with the flat side of its knife!";
    }

    @Override
    public String enemyDefeatedMessage() {
        return "a hole in the ground where the squirrel used to be. I wounder how the knife is doing.";
    }
}
