package ase.project.application.enemies.bosses;

import ase.project.application.action.specialattack.enemy.RingOfChaos;
import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class SoldierOfGodrick extends EnemyManager {

    public SoldierOfGodrick(String name, int currentHealth, int maxHealth, int power) {
        super("Soldier of Godrick", currentHealth, maxHealth, power);
        this.keyToDescription = "soldier_of_godrick";
        this.specialAttackList.put(1, new RingOfChaos());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Soldier of Godrick for " + damage + " damage!");
    }

}
