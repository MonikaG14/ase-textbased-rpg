package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class KeyVanish implements SpecialAttack {

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
        return "Kikimora uses its special attack KEY VANISH. \nThe Kikimora unleashes its notorious Key Vanish attack, causing keys within a certain radius to disappear into thin air. \nWith a mischievous giggle, it leaves its foes bewildered and frustrated, desperately searching for their mysteriously vanished keys\n";
    }

    @Override
    public String getName() {
        return "Key Vanish";
    }
}
