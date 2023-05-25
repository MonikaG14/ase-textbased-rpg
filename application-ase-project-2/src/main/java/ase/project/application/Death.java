package ase.project.application;

import ase.project.domain.action.DeathObserver;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.characters.player.Player;
import ase.project.domain.level.Level;

public class Death implements DeathObserver {

    private final Level level;

    public Death(Level level) {
        this.level = level;
    }

    @Override
    public void onCharacterDeath(Character character) {
        if (character instanceof Player) {
            onPlayerDeath(character);
        } else if (character instanceof Enemy) {
            onEnemyDeath((Enemy) character);
        }
    }

    public void onPlayerDeath(Character character) {
        character.dies();
    }

    public void onEnemyDeath(Enemy enemy) {
        level.removeDeadEnemy(enemy);
        enemy.dies();
    }
}
