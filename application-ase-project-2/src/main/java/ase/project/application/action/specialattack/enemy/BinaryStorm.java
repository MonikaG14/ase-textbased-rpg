package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class BinaryStorm implements SpecialAttack {

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
        return "The Tech-Priest uses his special attack BINARY STORM. \nThe Tech Priest channels the power of the machine spirits, unleashing a devastating surge of binary energy. \nSparks and arcs of electricity surround their mechanized form as they raise their augmented arms towards the sky. \nA vortex of pulsating energy forms above, crackling with technomantic power. \nWith a thunderous command, the Tech Priest releases the energy in a torrential downpour, engulfing their enemies in a storm of electrical fury. \nThe air crackles with the hum of machinery as the enemies' circuits overload and their systems malfunction, leaving them vulnerable and incapacitated.\n";
    }

    @Override
    public String getName() {
        return "Binary Storm";
    }
}
