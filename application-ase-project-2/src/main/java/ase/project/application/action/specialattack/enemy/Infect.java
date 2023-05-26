package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Infect implements SpecialAttack {

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println(this.getDescription());
        System.out.println("You took " + damage + " damage.\n");
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Phyrexian Mite uses its special attack INFECT. \nWhen the Phyrexian Mite unleashes its Infect attack. \nSuddenly, you start feeling itchy and begin to scratch yourself uncontrollably. \n";
    }

    @Override
    public String getName() {
        return "Infect";
    }
}
