package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.EnchantingVeil;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Samodiva extends EnemyManager {

    public Samodiva(String name, int currentHealth, int maxHealth, int power) {
        super("Samodiva", currentHealth, maxHealth, power);
        this.keyToDescription = "samodiva";
        this.specialAttackList.put(1, new EnchantingVeil());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Samodiva with basic attack for " + damage + " damage!");
    }
}
