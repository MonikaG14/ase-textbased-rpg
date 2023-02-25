package ase.project.application.player;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.npc.Enemy;
import ase.project.domain.player.Character;

public class Gladiator extends Character {
    private int endurance;

    public Gladiator(int intelligence, int strength, int dexterity, int health, int maxHealth, int endurance) {
        super(intelligence, strength, dexterity, health, maxHealth);
        this.endurance = endurance;
    }

    @Override
    public void basicAttack(Enemy target) {
        //ToDo mechanism to calculate attack damage: roll dice, calculate damage, do damage
    }

    @Override
    public void specialAttack(Enemy target, String attackName) {
        try {
            if (attackName.equals("Spin To Win")) {
                //hit multiple enemies, while clumsily spinning around in panic
            } else if (attackName.equals("Gladiator's Gambit")) {
                //it was all calculated... probably
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