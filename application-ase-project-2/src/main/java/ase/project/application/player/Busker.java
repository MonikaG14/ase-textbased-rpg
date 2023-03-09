package ase.project.application.player;

import ase.project.application.action.attacks.Earworm;
import ase.project.application.action.attacks.RickRoll;
import ase.project.application.action.attacks.UseSpecialAttack;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.dice.DiceRoller;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

import java.util.HashMap;
import java.util.Map;

public class Busker extends Character {
    private final int charisma;
    private final Map<String, SpecialAttack> specialAttacksList;

    public Busker(String name, int strength, int dexterity, int health, int maxHealth, String mana, int charisma) {
        super(name, strength, dexterity, health, maxHealth, mana);
        this.charisma = charisma;
        this.specialAttacksList = new HashMap<>();
        this.specialAttacksList.put("Earworm", new Earworm(5));
        this.specialAttacksList.put("RickRoll", new RickRoll(10));
    }

    @Override
    public void useBasicAttack(Enemy target) {
        int damage = DiceRoller.rollDice(6) + this.charisma;
        target.takeDamage(damage);
        System.out.println("You used your basic attack for " + damage + " damage!");
    }

    @Override
    public void useSpecialAttack(Enemy target, String attackName, int mana) {
        UseSpecialAttack.useSpecialAttack(target, attackName, mana, specialAttacksList);
    }

    @Override
    public void dies() {

    }
}