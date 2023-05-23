package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class WatchOut implements SpecialAttack {

    @Override
    public void performSpecialAttack(Character target) {
        int damage = DiceRoller.rollDice(20);
        target.attackOneself(damage);
        System.out.println(this.getKeyToDescription());
        System.out.println("Between the countless clashes of the blades, you hear one of the Watchers cry out: \n'Wait, I was on yor side!' before being struck down by his own brother in arms. You took " + damage + " damage.\n");
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public String getKeyToDescription() {
        return "Watch Out: Much to your surprise and horror you witness the Abyss Watcher cloning itself. \nAs you rub your eyes in disbelief, hoping the many potions you drank are the cause of this madness. \nyou see the two dark menacing figures now slowly approaching you. \nOut of nowhere, one of the watchers swiftly turns, unsheathing his weapon, to face his clone. Subsequently, you see the later mirroring the actions of his brother in arm  \nSurely, you must be hallucinating. What is going on here? \nSwords clashing, sparks flying, and blood spattering everywhere. \nThe Abyss Watchers seem completely oblivious to the your presence, locked in a never-ending cycle of self-destruction. \n";
    }

    @Override
    public String getName() {
        return "Watch Out";
    }
}
