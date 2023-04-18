package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class SpinToWin implements SpecialAttack {

    private final int manaCost;

    public SpinToWin(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("As you begin to spin, your character looks more like a drunken octopus than a fearsome warrior. \nBut as the enemy stares in disbelief, your flailing arms suddenly connect with a critical hit! \nYou spin again, this time even more frantically, hoping to avoid their deadly strikes. \nYou might not look very intimidating, but you're definitely getting the job done - in your own unique way.");
        System.out.println("You did" + damage + " damage.");
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    public String getKeyToDescription() {
        return "spin_to_win";
    }

    @Override
    public String getName() {
        return "Spin To Win";
    }
}
