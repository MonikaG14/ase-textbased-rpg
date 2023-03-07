package ase.project.application.player;

import ase.project.application.action.attacks.UseBasicAttack;
import ase.project.application.action.attacks.GladiatorsGambit;
import ase.project.application.action.attacks.SpinToWin;
import ase.project.application.dice.DiceRollerImpl;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Gladiator extends Character {
    private int endurance;
    private final Map<String, SpecialAttack> specialAttackList;

    public Gladiator(String name, int strength, int dexterity, int health, int maxHealth, String mana) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.specialAttackList = new HashMap<>();
        this.specialAttackList.put("Gladiator's Gambit", new GladiatorsGambit(5, new DiceRollerImpl(new Random())));
        this.specialAttackList.put("Spin To Win", new SpinToWin(10,new DiceRollerImpl(new Random())));
    }

    @Override
    public void useBasicAttack(Enemy target) {
        UseBasicAttack useBasicAttack = new UseBasicAttack(new DiceRollerImpl(new Random()));
        useBasicAttack.useBasicAttack(target);
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        try {
            SpecialAttack specialAttack = specialAttackList.get(attackName);
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