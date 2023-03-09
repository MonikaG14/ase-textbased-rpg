package ase.project.application.player;

import ase.project.application.action.attacks.FireballBarrage;
import ase.project.application.action.attacks.FlameTsunami;
import ase.project.application.action.attacks.UseSpecialAttack;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;

public class Astronomer extends Player {
    private final int intelligence;
    private final Map<String, SpecialAttack> specialAttackList;

    public Astronomer(String name, int strength, int dexterity, int health, int maxHealth, String mana, int intelligence) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.intelligence = intelligence;
        this.specialAttackList = new HashMap<>();
        this.specialAttackList.put("Fireball Barrage", new FireballBarrage(5));
        this.specialAttackList.put("Flame Tsunami", new FlameTsunami(10));
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.intelligence;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }

    @Override
    public void useSpecialAttack(Character target, String attackName, int mana) {
        UseSpecialAttack.useSpecialAttack(target, attackName, mana, specialAttackList);
    }

    public void drink(){
    }

    @Override
    public void dies() {

    }
}