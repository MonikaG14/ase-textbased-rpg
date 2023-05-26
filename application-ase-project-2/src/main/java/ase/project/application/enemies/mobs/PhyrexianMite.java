package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.Infect;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class PhyrexianMite extends EnemyManager {

    public PhyrexianMite(String name, int currentHealth, int maxHealth, int power) {
        super("Phyrexian Mite", currentHealth, maxHealth, power);
        this.keyToDescription = "phyrexian_mite";
        this.specialAttackList.put(1, new Infect());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Phyrexian Mite with basic attack for " + damage + " damage!");
    }
}
