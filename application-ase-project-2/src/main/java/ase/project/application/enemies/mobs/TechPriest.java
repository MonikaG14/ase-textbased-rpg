package ase.project.application.enemies.mobs;

import ase.project.application.action.specialattack.enemy.BinaryStorm;
import ase.project.application.action.specialattack.enemy.ChromaticCascade;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class TechPriest extends EnemyManager {

    public TechPriest(String name, int currentHealth, int maxHealth, int power) {
        super("Tech-Priest", currentHealth, maxHealth, power);
        this.keyToDescription = "tech_priest";
        this.specialAttackList.put(1, new BinaryStorm());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Tech-Priest with basic attack for " + damage + " damage!");
    }
}
