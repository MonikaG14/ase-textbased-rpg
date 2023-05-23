package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class RingOfChaos implements SpecialAttack {

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println(this.getKeyToDescription());
        System.out.println("You took " + damage + " damage.\n");
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public String getKeyToDescription() {
        return "Soldier of Godrick unleashes its devastating Ring of Chaos attack, causing players to experience an overwhelming sensation of confusion and bewilderment. \nAs you struggle to comprehend the intricate mechanics and dodge the chaotic onslaught, your health steadily dwindles, \nyour souls yearning for respite from this merciless dance of agony. \n\n";
    }

    @Override
    public String getName() {
        return "Ring of Chaos";
    }
}
