package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.KeyVanish;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Kikimora extends EnemyManager {

    public Kikimora(String name, int currentHealth, int maxHealth, int power) {
        super("Kikimora", currentHealth, maxHealth, power);
        this.keyToDescription = "kikimora";
        this.specialAttackList.put(1, new KeyVanish());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Kikimora with basic attack for " + damage + " damage!");
    }
}
