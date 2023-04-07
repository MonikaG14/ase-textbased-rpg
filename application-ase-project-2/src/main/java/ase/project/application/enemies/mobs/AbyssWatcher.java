package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.WatchOut;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class AbyssWatcher extends EnemyManager {

    public AbyssWatcher(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth, power);
        this.keyToDescription = "abyss_watcher";
        this.specialAttackList.put(1, new WatchOut());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Abyss Watcher for " + damage + " damage!");
    }
}
