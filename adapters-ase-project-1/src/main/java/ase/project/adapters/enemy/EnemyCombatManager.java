package ase.project.adapters.enemy;

import ase.project.application.DeathObserverManager;
import ase.project.application.enemies.EnemyManager;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.characters.player.Player;
import ase.project.domain.level.Level;

public class EnemyCombatManager {

    private final DeathObserverManager deathObserverManager;

    public EnemyCombatManager(DeathObserverManager deathObserverManager) {
        this.deathObserverManager = deathObserverManager;
    }

    public void chooseAction(EnemyManager enemy, Player player, Level level) throws InvalidAttackException {
        enemy.chooseBetweenSpecialAndBasicAttack(player);
        deathObserverManager.checkIfDead(player, level);
    }
}
