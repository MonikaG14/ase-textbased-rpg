package ase.project.adapters.player;

import ase.project.adapters.DeathObserverManager;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.InputProvider;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.HashMap;
import java.util.Map;

public class PlayerCombatManager {
    private final InputProvider inputProvider;
    private final DeathObserverManager deathObserverManager;
    private Map<Integer, SpecialAttack> attackMap;
    private Map<Integer, Enemy> enemyMap;

    public PlayerCombatManager(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        this.deathObserverManager = new DeathObserverManager();
    }

    public void chooseBetweenSpecialAndBasicAttack(PlayerManager player, Level level) throws InvalidAttackException {
        System.out.println("Do you want to use your basic or your special attack? ");
        System.out.println("1. Basic Attack");
        System.out.println("2. Special Attack");

        boolean validChoice = false;
        do {
            int choice = inputProvider.readInt();
            if (choice == 1) {
                this.useBasicAttackOnTarget(player, level);
                validChoice = true;
            } else if (choice == 2) {
                this.useSpecialAttackOnTarget(player, level);
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        } while (!validChoice);
    }

    public void useBasicAttackOnTarget(PlayerManager player, Level level) {
        Enemy enemy = this.chooseTarget(level);
        player.useBasicAttack(enemy);
        deathObserverManager.checkIfDead(enemy, level);
    }

    public void useSpecialAttackOnTarget(PlayerManager player, Level level) throws InvalidAttackException {
        boolean validChoice = false;
        while (!validChoice) {
            String attackName = this.chooseSpecialAttack(player);
            Enemy enemy = chooseTarget(level);
            try {
                player.useSpecialAttack(enemy, attackName);
                deathObserverManager.checkIfDead(enemy, level);
                validChoice = true; // Break out of the loop if the attack is successful
            } catch (InsufficientManaException e) {
                System.out.println("You do not have enough mana for this attack!");
                System.out.println("Please choose again.");
            }
        }
    }

    public String chooseSpecialAttack(PlayerManager player) {
        attackMap = iterateSpecialAttacks(player);

        while (true) {
            int choice = inputProvider.readInt();

            if (choice >= 1 && choice <= attackMap.size()) {
                SpecialAttack specialAttack = attackMap.get(choice);
                return specialAttack.getName();
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public Enemy chooseTarget(Level level) {
        enemyMap = iterateEnemies(level);

        while (true) {
            int choice = inputProvider.readInt();

            if (enemyMap.containsKey(choice)) {
                return enemyMap.get(choice);
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public Map<Integer, SpecialAttack> iterateSpecialAttacks(PlayerManager player) {
        System.out.println("Choose your a special attack to use: ");
        Map<String, SpecialAttack> specialAttacks = player.getSpecialAttackList();
        attackMap = new HashMap<>();

        int i = 1;
        for (Map.Entry<String, SpecialAttack> entry : specialAttacks.entrySet()) {
            System.out.println(i + ". " + entry.getKey());
            attackMap.put(i, entry.getValue());
            i++;
        }
        return attackMap;
    }

    public Map<Integer, Enemy> iterateEnemies(Level level) {
        System.out.println("Choose an enemy to attack: ");
        enemyMap = level.getEnemies();

        for (Map.Entry<Integer, Enemy> entry : enemyMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
        return enemyMap;
    }
}
