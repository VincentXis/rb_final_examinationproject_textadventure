package se.nackademin.theWawaAdventure.game;

import se.nackademin.theWawaAdventure.enemy.Enemy;
import se.nackademin.theWawaAdventure.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The simplest combat system ever probably but it helps to decide the outcome of a fight
 * as well as allowing the player to actually beat the 'game'
 */
public class CombatSystem {
    private Item item;
    private Enemy enemy;
    private List<String> fightScene;
    private boolean enemyDefeated;

    public CombatSystem(Item item, Enemy enemy) {
        this.item = item;
        this.enemy = enemy;
        fightScene = new ArrayList<>();
        resolveCombat();
    }

    private void resolveCombat() {
        fightScene.add(item.getUseDescription(enemy.getType()));
        fightScene.add("");
        if (item.getName().equalsIgnoreCase(enemy.weakAgainst())) {
            fightScene.add(item.getUseSuccess(enemy.getType()));
            enemyDefeated = true;
        } else {
            fightScene.add(item.getUseFailure(enemy.getType()));
            fightScene.add(enemy.attack());
            enemyDefeated = false;
        }
        fightScene.add("");
    }

    public List<String> getFightScene() {
        return fightScene;
    }

    public boolean isEnemyDefeated() {
        return enemyDefeated;
    }


}
