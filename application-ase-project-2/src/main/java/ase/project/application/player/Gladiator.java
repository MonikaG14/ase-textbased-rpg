package ase.project.application.player;

import ase.project.application.action.Mana;
import ase.project.application.action.attacks.GladiatorsGambit;
import ase.project.application.action.attacks.SpinToWin;
import ase.project.application.action.attacks.ChooseSpecialAttack;
import ase.project.application.exception.InvalidManaException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Player {
    private final int endurance;
    private final Map<String, SpecialAttack> specialAttackList;

    public Gladiator(String name, int strength, int dexterity, int health, int maxHealth, int mana, int endurance) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.endurance = endurance;
        this.specialAttackList = new HashMap<>();
        this.specialAttackList.put("Gladiator's Gambit", new GladiatorsGambit(5));
        this.specialAttackList.put("Spin To Win", new SpinToWin(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.endurance;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }


    public void useSpecialAttack(Character target, String attackName) {
        SpecialAttack specialAttack = ChooseSpecialAttack.chooseSpecialAttack(specialAttackList, attackName);
        try {
            Mana.checkMana(mana, specialAttack.getManaCost());
            specialAttack.performSpecialAttack(target, attackName);
            mana = Mana.useMana(mana, specialAttack.getManaCost());
        } catch (InvalidManaException manaException) {
            System.out.println(manaException.getMessage());
        }
    }

    @Override
    public void dies() {

    }

    public int getEndurance() {
        return this.endurance;
    }
}