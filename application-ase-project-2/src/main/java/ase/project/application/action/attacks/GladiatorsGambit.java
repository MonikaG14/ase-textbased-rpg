package ase.project.application.action.attacks;

import ase.project.application.dice.DiceRollerImpl;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;

public class GladiatorsGambit implements SpecialAttack {
    private final int manaCost;
    private final DiceRollerImpl diceRoller;

    public GladiatorsGambit(int manaCost, DiceRollerImpl diceRoller) {
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
            System.out.println("Scared to the core, you feel as if your limbs are made of lead. \nMoving them feels like rolling Sisyphus's boulder up a mountain. As if emerging from a dream, \nyou notice that your enemies are distracted, busy laughing at your silly expressions. Your chance to strike is now or never. \n\nYou did" + damage + " damage and used " + manaCost + " mana. You have " + mana + " left.");
        }
    }

    public String getDescription() {
        return "Gladiator's Gambit: The gladiator intentionally loses the first few rounds of the fight \nto lull the opponent into a false sense of security, then delivers a surprise attack \nwhen they least expect it.";
    }
}
