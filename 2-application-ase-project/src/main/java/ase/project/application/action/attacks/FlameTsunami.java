package ase.project.application.action.attacks;

import ase.project.application.dice.DiceRollerImpl;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;

public class FlameTsunami implements SpecialAttack {
    private final int manaCost;
    private final DiceRollerImpl diceRoller;

    public FlameTsunami(int manaCost, DiceRollerImpl diceRoller) {
        this.manaCost = manaCost;
        this.diceRoller = diceRoller;
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        if(mana < manaCost) {
            System.out.println("Not enough mana to use!");
        } else {
            mana -= manaCost;
            int damage = diceRoller.rollDice(20);
            target.takeDamage(damage);
            System.out.println("\n\nYou did " + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Flame Tsunami: Summon a massive wave of fire that will engulf everything in its path, because sometimes subtlety is overrated";
    }
}
