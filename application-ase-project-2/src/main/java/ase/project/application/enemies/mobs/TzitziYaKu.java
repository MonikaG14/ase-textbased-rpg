package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.ChromaticCascade;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class TzitziYaKu extends EnemyManager {

    public TzitziYaKu(String name, int currentHealth, int maxHealth, int power) {
        super("Tzitzi-Ya-Ku", currentHealth, maxHealth, power);
        this.keyToDescription = "tzitzi";
        this.specialAttackList.put(1, new ChromaticCascade());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Tzitzi-Ya-Ku with basic attack for " + damage + " damage!");
    }
}
