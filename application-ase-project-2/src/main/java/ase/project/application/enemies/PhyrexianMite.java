package ase.project.application.enemies;

import ase.project.application.action.specialattack.enemy.Infest;
import ase.project.application.player.EnemyClass;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class PhyrexianMite extends EnemyClass {

    public PhyrexianMite(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth, power);
        this.specialAttackList.put(1, new Infest());
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Phyrexian Mite for " + damage + " damage!");
    }

    @Override
    public String getEnemyDescription() {
        return "The Phyrexian Mite is a small but deadly creature from the plane of Phyrexia. \nIt has a metallic carapace that covers its entire body and a set of sharp mandibles that it uses to bite its prey. \nThe mite is extremely agile and can move quickly across any surface, making it difficult to catch or avoid. \nIt is a carrier of Phyrexian oil, which it uses to infect other creatures and spread the Phyrexian corruption.";
    }
}
