package ase.project.domain.characters.enemy;

import ase.project.domain.characters.Character;

import java.util.Objects;

public abstract class Enemy extends Character {

    protected String keyToDescription;
    protected int power;

    public Enemy(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void dies() {
        System.out.println("Congratulations! " + this.getName() + " died!");
        System.out.println();
    }

    public String getKeyToDescription() {
        return keyToDescription;
    }
}
