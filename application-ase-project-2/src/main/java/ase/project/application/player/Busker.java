package ase.project.application.player;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

public class Busker extends Character {
    private int charisma;

    public Busker(int intelligence, int strength, int dexterity, int health, int maxHealth, int charisma) {
        super(intelligence, strength, dexterity, health, maxHealth);
        this.charisma = charisma;
    }

    @Override
    public void basicAttack(Enemy target) {
        //ToDo mechanism to calculate attack damage: roll dice, calculate damage, do damage
    }

    @Override
    public void specialAttack(Enemy target, String attackName) {
        try {
            if (attackName.equals("RickRoll")) {
                //not this again...
            } else if (attackName.equals("Earworm")) {
                //distracted
            } else {
                throw new InvalidAttackException("Invalid attack: " + attackName);
            }
        } catch (InvalidAttackException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean die() {
        return false;
    }

    @Override
    public int moves() {
        return 0;
    }
}