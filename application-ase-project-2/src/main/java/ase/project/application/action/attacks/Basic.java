package ase.project.application.action.attacks;

import ase.project.application.dice.DiceRollerImpl;
import ase.project.domain.action.attack.BasicAttack;
import ase.project.domain.npc.Enemy;

public class Basic implements BasicAttack{
    private final DiceRollerImpl diceRoller;

    public Basic(DiceRollerImpl diceRoller) {
        this.diceRoller = diceRoller;
    }

    @Override
    public void useBasicAttack(Enemy target) {
        int damage = diceRoller.rollDice(6);
        target.takeDamage(damage);
        System.out.println("You used you basic for " + damage + " damage!");
    }
}
