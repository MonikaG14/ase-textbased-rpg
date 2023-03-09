package ase.project.application.action.attacks;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.npc.Enemy;

public class Earworm implements SpecialAttack {
    private final int manaCost;

    public Earworm(int manaCost) {
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
            System.out.println("You just unleashed the Earworm attack. \nIt's catchy tune worms its way into your enemies' brains and refuses to let go, \nleaving them in a dazed state. \n\nYou did " + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Earworm: You start humming a catchy tune and infects the enemy with an ear worm, causing them to become distracted and unable to focus. \nThe enemy takes damage as their mind is consumed by the incessant melody.";
    }
}
