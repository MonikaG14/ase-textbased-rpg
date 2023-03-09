package ase.project.application.enemies;

import ase.project.application.action.attacks.UseSpecialAttack;
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

    @Override
    public void useSpecialAttack(Character target, String attackName, int mana) {
        UseSpecialAttack.useSpecialAttack(target, attackName, mana, specialAttackList);
    }

    @Override
    public void dies() {

    }
}
