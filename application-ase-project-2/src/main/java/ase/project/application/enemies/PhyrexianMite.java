package ase.project.application.enemies;

import ase.project.application.action.SpecialAttackService;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.characters.Enemy;

import java.util.HashMap;
import java.util.Map;

public class PhyrexianMite extends Enemy {
    private final Map<String, SpecialAttack> specialAttackList;

    public PhyrexianMite(String name, int currentHealth, int maxHealth, int power, Map<String, SpecialAttack> specialAttackList) {
        super(name, currentHealth, maxHealth, power);
        this.specialAttackList = new HashMap<>();
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Phyrexian Mite for" + damage + " damage!");
    }

    public void useSpecialAttack(Character target) throws InvalidAttackException {
        SpecialAttack specialAttack = SpecialAttackService.chooseRandomSpecialAttack(specialAttackList);
        specialAttack.performSpecialAttack(target);
    }

    @Override
    public String getEnemyDescription() {
        return "The Phyrexian Mite is a small but deadly creature from the plane of Phyrexia. \nIt has a metallic carapace that covers its entire body and a set of sharp mandibles that it uses to bite its prey. \nThe mite is extremely agile and can move quickly across any surface, making it difficult to catch or avoid. \nIt is a carrier of Phyrexian oil, which it uses to infect other creatures and spread the Phyrexian corruption.";
    }
}
