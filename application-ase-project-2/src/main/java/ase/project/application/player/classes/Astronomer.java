package ase.project.application.player.classes;

import ase.project.application.action.specialattack.player.FireballBarrage;
import ase.project.application.action.specialattack.player.FlameTsunami;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Astronomer extends PlayerManager {
    private final int intelligence;

    public Astronomer(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions, int intelligence) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.intelligence = intelligence;
        this.specialAttackList.put("Fireball Barrage", new FireballBarrage(5));
        this.specialAttackList.put("Flame Tsunami", new FlameTsunami(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.intelligence;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }

    public int getIntelligence() {
        return this.intelligence;
    }
}