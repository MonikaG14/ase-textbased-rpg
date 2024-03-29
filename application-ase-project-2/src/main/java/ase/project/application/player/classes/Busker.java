package ase.project.application.player.classes;

import ase.project.application.action.specialattack.player.Earworm;
import ase.project.application.action.specialattack.player.RickRoll;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class Busker extends PlayerManager {
    private final int charisma;

    public Busker(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions, int charisma) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.charisma = charisma;
        this.specialAttackList.put("Earworm", new Earworm(5));
        this.specialAttackList.put("RickRoll", new RickRoll(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.charisma;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }

    public int getCharisma() {
        return this.charisma;
    }
}