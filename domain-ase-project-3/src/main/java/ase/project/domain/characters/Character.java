package ase.project.domain.characters;

import ase.project.domain.action.attack.BasicAttack;

public abstract class Character implements BasicAttack {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;

    public Character(String name, int currentHealth, int maxHealth) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int takeDamage(int damage) {
        currentHealth -= damage;
        return currentHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void dies(Character character) {
        if (!checkIfDead(character)) {
            throw new IllegalArgumentException("You died...");
        }
    }

    public boolean checkIfDead(Character character) {
        return character.getCurrentHealth() <= 0;
    }
}
