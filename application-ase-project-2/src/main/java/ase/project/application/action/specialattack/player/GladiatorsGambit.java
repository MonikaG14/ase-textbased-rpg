package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class GladiatorsGambit implements SpecialAttack {

    private final String nameOfAttack = "gladiators_gambit";
    private final int manaCost;

    public GladiatorsGambit(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("Scared to the core, you feel as if your limbs are made of lead. \nMoving them feels like rolling Sisyphus's boulder up a mountain. As if emerging from a dream, \nyou notice that your enemies are distracted, busy laughing at your silly expressions. Your chance to strike is now or never.");
        System.out.println("You did" + damage + " damage.");
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    public String getKeyToDescription() {
        return nameOfAttack;
    }
}
