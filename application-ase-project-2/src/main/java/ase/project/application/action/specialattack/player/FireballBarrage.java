package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class FireballBarrage implements SpecialAttack {

    private final int manaCost;

    public FireballBarrage(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("Your hands light up like a disco ball and suddenly, hundreds of tiny fireballs shoot out in all directions \nlike an over-caffeinated toddler with a sugar rush, creating a fiery rainstorm that engulfs everything in sight. \nIt's like a fireworks show, but instead of pretty colors, it's just hot, fiery destruction.");
        System.out.println("You did " + damage + " damage.");
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    public String getKeyToDescription() {
        return "fireball_barrage";
    }

    @Override
    public String getName() {
        return "Fireball Barrage";
    }
}
