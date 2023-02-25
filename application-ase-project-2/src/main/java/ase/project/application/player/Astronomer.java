package ase.project.application.player;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

public class Astronomer extends Character {
    private int mana;

    public Astronomer(int intelligence, int strength, int dexterity, int health, int maxHealth, int mana) {
        super(intelligence, strength, dexterity, health, maxHealth);
        this.mana = mana;
    }

    @Override
    public void basicAttack(Enemy target) {
        //ToDo mechanism to calculate attack damage: roll dice, calculate damage, do damage
    }

    @Override
    public void specialAttack(Enemy target, String attackName) {
        try {
            if (attackName.equals("Spontaneous Combustion")) {
                //All my spells smell like burnt hair lately
            } else if (attackName.equals("Lightning Strike")) {
                //well, this got out of hand
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
        //ToDo roll dice, calculate movement
        return 0;
    }
}