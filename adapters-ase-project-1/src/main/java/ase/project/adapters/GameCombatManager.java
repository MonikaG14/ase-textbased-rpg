package ase.project.adapters;

import ase.project.application.enemies.EnemyManager;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.characters.player.PlayerStatsRepository;
import ase.project.domain.level.Level;

import java.util.Map;

public class GameCombatManager {

    private final PlayerManager player;
    private final Map<Integer, Enemy> enemies;
    private final PlayerActionManager playerActionManager;
    private final EnemyCombatManager enemyCombatManager;
    private final Level level;

    private int currentCharacterIndex;

    public GameCombatManager(PlayerManager player, Map<Integer, Enemy> enemies, PlayerStatsRepository playerStatsRepository, InputProvider inputProvider, Level level) {
        this.player = player;
        this.enemies = enemies;
        this.level = level;
        this.playerActionManager = new PlayerActionManager(playerStatsRepository, inputProvider);
        DeathObserverManager deathObserverManager = new DeathObserverManager();
        this.enemyCombatManager = new EnemyCombatManager(deathObserverManager);
        this.currentCharacterIndex = 0;
    }

    public boolean startCombat() throws InvalidAttackException, InsufficientManaException {
        while (!enemies.isEmpty()) {
            runLevelCombat();
        }
        return true;
    }

    public void runLevelCombat() throws InsufficientManaException, InvalidAttackException {
        boolean playerTurn = true;

        while (!enemies.isEmpty() && !player.isDead()) {
            Character currentPlayer;

            if (playerTurn) {
                playerActionManager.chooseAction(player, level);
            } else {
                if (enemies.size() == 1) {
                    currentPlayer = enemies.get(1);
                } else {
                    currentPlayer = getCurrentEnemy();
                }

                if (currentPlayer != null && !currentPlayer.isDead()) {
                    enemyCombatManager.chooseAction((EnemyManager) currentPlayer, player, level);
                }
            }

            playerTurn = !playerTurn;
            updateCurrentCharacterIndex();
        }
    }

    private void updateCurrentCharacterIndex() {
        if (!enemies.isEmpty()) {
            currentCharacterIndex = (currentCharacterIndex + 1) % enemies.size();
            if (currentCharacterIndex == 0) {
                currentCharacterIndex = enemies.size();
            }
        }
    }

    private Character getCurrentEnemy() {
        if (currentCharacterIndex >= 0 && currentCharacterIndex < enemies.size()) {
            return enemies.get(currentCharacterIndex);
        } else {
            return null;
        }
    }
}
