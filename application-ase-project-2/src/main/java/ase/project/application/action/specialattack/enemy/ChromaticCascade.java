package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class ChromaticCascade implements SpecialAttack {

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
        return "The Tzitzi Ya Ku its dazzling and magical special attack CHROMATIC CASCADE. \nWith a burst of radiant energy, shimmering crystals form a vibrant kaleidoscope of violet, pink, and blue hues. \nThe air fills with an explosion of colors as the cascading brilliance disorients foes, leaving them momentarily stunned and susceptible to follow-up attacks.\n";
    }

    @Override
    public String getName() {
        return "Chromatic Cascade";
    }
}
