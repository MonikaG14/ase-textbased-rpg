package ase.project.application.player;

import ase.project.application.action.specialattack.GladiatorsGambit;
import ase.project.application.action.specialattack.SpinToWin;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

import java.util.Map;

public class Gladiator extends PlayerClass {
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

    @Override
    public void dies() {

    }

    public int getEndurance() {
        return this.endurance;
    }

    public Map<String, SpecialAttack> getSpecialAttackList() {
        return this.specialAttackList;
    }
}