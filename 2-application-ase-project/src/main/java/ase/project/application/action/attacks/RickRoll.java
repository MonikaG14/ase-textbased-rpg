package ase.project.application.action.attacks;

import ase.project.application.dice.DiceRollerImpl;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;

public class RickRoll implements SpecialAttack {
    private final int manaCost;
    private final DiceRollerImpl diceRoller;
    public RickRoll(int manaCost, DiceRollerImpl diceRoller) {
        this.manaCost = manaCost;
        this.diceRoller = diceRoller;
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        if (mana < manaCost) {
            System.out.println("Not enough mana to use!");
        } else {
            mana -= manaCost;
            int damage = diceRoller.rollDice(20);
            target.takeDamage(damage);
            System.out.println("With a quick strum of your guitar and a mischievous glint in your eye, \nyou unleash a devastating barrage of never gonna give you up's and never gonna let you down's. \nYour enemies are left stunned and singing along as they're pelted with the unrelenting force \nof Rick Astley's timeless melody. \n\nYou did" + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Rick Roll: this attack is a powerful and devastating technique \nthat can completely disorient and distract enemies. Beware, though - this attack is not for the faint of heart, \nas you'll need to have a certain level of swag and style to pull it off properly.";
    }
}
