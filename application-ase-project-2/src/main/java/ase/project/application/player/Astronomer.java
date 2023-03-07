package ase.project.application.player;

import ase.project.application.action.attacks.Basic;
import ase.project.application.action.attacks.FireballBarrage;
import ase.project.application.action.attacks.FlameTsunami;
import ase.project.application.dice.DiceRollerImpl;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Astronomer extends Character {
    private int intelligence;
    private final Map<String, SpecialAttack> specialAttackList;

    public Astronomer(String name, int strength, int dexterity, int health, int maxHealth, String mana) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.specialAttackList = new HashMap<>();
        this.specialAttackList.put("Fireball Barrage", new FireballBarrage(5,new DiceRollerImpl(new Random())));
        this.specialAttackList.put("Flame Tsunami", new FlameTsunami(10, new DiceRollerImpl(new Random())));
    }

    @Override
    public void useBasicAttack(Enemy target) {
        Basic basic = new Basic(new DiceRollerImpl(new Random()));
        basic.useBasicAttack(target);
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

    public void drink(){

    }

    @Override
    public void dies() {

    }
}