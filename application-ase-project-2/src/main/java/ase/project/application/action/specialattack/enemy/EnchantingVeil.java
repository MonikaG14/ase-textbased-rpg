package ase.project.application.action.specialattack.enemy;

import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class EnchantingVeil implements SpecialAttack {

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
        return "Samodiva uses its special attack ENCHANTING VEIL. \nWith a wave of her delicate hand, the Samodiva conjures a shimmering veil of enchantment. \nThe air fills with an alluring fragrance, and a mesmerizing kaleidoscope of colors dances around her. \nAs the veil envelops her enemies, their senses become entranced, their movements sluggish and disoriented. \nBewitched by the ethereal beauty before them, they are left vulnerable and unable to resist her enchanting powers.\n";
    }

    @Override
    public String getName() {
        return "Enchanting Veil";
    }
}
