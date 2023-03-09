package ase.project.application.action.attacks;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class FlameTsunami implements SpecialAttack {
    private final int manaCost;

    public FlameTsunami(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void useSpecialAttack(Character target, String attackName, int mana) {
        if(mana < manaCost) {
            System.out.println("Not enough mana to use!");
        } else {
            mana -= manaCost;
            int damage = DiceRoller.rollDice(20);
            target.takeDamage(damage);
            System.out.println("You did " + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Flame Tsunami: Summon a massive wave of fire that will engulf everything in its path, because sometimes subtlety is overrated";
    }
}
