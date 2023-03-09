package ase.project.application.action.attacks;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.npc.Enemy;

public class FireballBarrage implements SpecialAttack {
    private final int manaCost;
    public FireballBarrage(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        if(mana < manaCost) {
            System.out.println("Not enough mana to use!");
        } else {
            mana -= manaCost;
            int damage = DiceRoller.rollDice(20);
            target.takeDamage(damage);
            System.out.println("Your hands light up like a disco ball and suddenly, hundreds of tiny fireballs shoot out in all directions \nlike an over-caffeinated toddler with a sugar rush, creating a fiery rainstorm that engulfs everything in sight. \nIt's like a fireworks show, but instead of pretty colors, it's just hot, fiery destruction. \n\nYou did " + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Fireball Barrage: Summon a rain of fireballs from the sky, because why not make it rain fire?";
    }
}
