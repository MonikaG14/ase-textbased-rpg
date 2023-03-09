package ase.project.application.action.attacks;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class SpinToWin implements SpecialAttack {
    private final int manaCost;

    public SpinToWin(int manaCost) {
        this.manaCost = manaCost;
    }
    @Override
    public void useSpecialAttack(Character target, String attackName, int mana) {
        if (mana < manaCost) {
            System.out.println("Not enough mana to use!");
        } else {
            mana -= manaCost;
            int damage = DiceRoller.rollDice(20);
            target.takeDamage(damage);
            System.out.println("As you begin to spin, your character looks more like a drunken octopus than a fearsome warrior. \nBut as the enemy stares in disbelief, your flailing arms suddenly connect with a critical hit! \nYou spin again, this time even more frantically, hoping to avoid their deadly strikes. \nYou might not look very intimidating, but you're definitely getting the job done - in your own unique way.");
            System.out.println("You did" + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Spin To Win: Turn you panic-stricken daze into a deadly weapon";
    }
}
