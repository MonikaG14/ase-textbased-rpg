package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class FlameTsunami implements SpecialAttack {

    private final String nameOfAttack = "flame_tsunami";
    private final int manaCost;

    public FlameTsunami(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("You did " + damage + " damage.");
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    public String getKeyToDescription() {
        return nameOfAttack;
    }
}
