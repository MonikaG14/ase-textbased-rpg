package ase.project.application.player;

import ase.project.application.action.Mana;
import ase.project.application.action.attacks.Earworm;
import ase.project.application.action.attacks.RickRoll;
import ase.project.application.action.attacks.ChooseSpecialAttack;
import ase.project.application.exception.InvalidManaException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;

public class Busker extends Player {
    private final int charisma;
    private final Map<String, SpecialAttack> specialAttackList;

    public Busker(String name, int strength, int dexterity, int health, int maxHealth, int mana, int charisma) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.charisma = charisma;
        this.specialAttackList = new HashMap<>();
        this.specialAttackList.put("Earworm", new Earworm(5));
        this.specialAttackList.put("RickRoll", new RickRoll(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.charisma;
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

    public int getCharisma() {
        return this.charisma;
    }
}