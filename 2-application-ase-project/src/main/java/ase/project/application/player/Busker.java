package ase.project.application.player;

import ase.project.application.action.attacks.UseBasicAttack;
import ase.project.application.action.attacks.Earworm;
import ase.project.application.action.attacks.RickRoll;
import ase.project.application.dice.DiceRollerImpl;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Busker extends Character {
    private int charisma;
    private final Map<String, SpecialAttack> specialAttacksList;

    public Busker(String name, int strength, int dexterity, int health, int maxHealth, String mana) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.specialAttacksList = new HashMap<>();
        this.specialAttacksList.put("Earworm", new Earworm(5, new DiceRollerImpl(new Random())));
        this.specialAttacksList.put("RickRoll", new RickRoll(10, new DiceRollerImpl(new Random())));
    }

    @Override
    public void useBasicAttack(Enemy target) {
        UseBasicAttack useBasicAttack = new UseBasicAttack(new DiceRollerImpl(new Random()));
        useBasicAttack.useBasicAttack(target);
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        try {
            SpecialAttack specialAttack = specialAttacksList.get(attackName);
            if (specialAttack != null) {
                specialAttack.useSpecialAttack(target, attackName, mana);
            } else {
                throw new InvalidAttackException("Invalid attack: " + attackName);
            }
        } catch (InvalidAttackException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dies() {

    }
}