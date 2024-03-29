package ase.project.application.action.specialattack.player;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class RickRoll implements SpecialAttack {

    private final int manaCost;

    public RickRoll(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.takeDamage(damage);
        System.out.println("With a quick strum of your guitar and a mischievous glint in your eye, \nyou unleash a devastating barrage of never gonna give you up's and never gonna let you down's. \nYour enemies are left stunned and singing along as they're pelted with the unrelenting force \nof Rick Astley's timeless melody.\n");
        System.out.println("You did" + damage + " damage.\n");
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    public String getDescription() {
        return "rick_roll";
    }

    @Override
    public String getName() {
        return "RickRoll";
    }
}
