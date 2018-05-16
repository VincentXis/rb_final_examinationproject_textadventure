package se.nackademin.theWawaAdventure.enemy;

public class Mummy implements Enemy {
    private boolean isAlive;

    public Mummy() {
        isAlive = true;
    }

    @Override
    public String getType() {
        return "Mummy";
    }

    @Override
    public String getDescription() {
        return "a very old and ashy looking mummy";
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String weakAgainst() {
        return "Lotion";
    }

    @Override
    public String die() {
        isAlive = false;
        return "the mummy wanders off now that its skin is soft again.";
    }

    @Override
    public String attack() {
        return "the mummy curses the shit out of you! HAH!";
    }

    @Override
    public String enemyDefeatedMessage() {
        return "the air feels less dry now that the mummy is gone.";
    }
}
