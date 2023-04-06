package ase.project.application.player.classes;

import ase.project.application.action.specialattack.player.GladiatorsGambit;
import ase.project.application.action.specialattack.player.SpinToWin;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Gladiator extends PlayerManager {
    private final int endurance;

    public Gladiator(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions, int endurance) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.endurance = endurance;
        this.specialAttackList.put("Gladiator's Gambit", new GladiatorsGambit(5));
        this.specialAttackList.put("Spin To Win", new SpinToWin(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.endurance;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }

    public int getEndurance() {
        return this.endurance;
    }
}