package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Earworm implements SpecialAttack {
    private final int manaCost;

    public Earworm(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("You just unleashed the Earworm attack. \nIt's catchy tune worms its way into your enemies' brains and refuses to let go, \nleaving them in a dazed state.");
        System.out.println("You did" + damage + " damage.");
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    public String getSpecialAttackDescription() {
        return "Earworm: You start humming a catchy tune and infects the enemy with an ear worm, causing them to become distracted and unable to focus. \nThe enemy takes damage as their mind is consumed by the incessant melody.";
    }
}
