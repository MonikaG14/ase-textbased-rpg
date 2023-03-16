package ase.project.domain.characters;

import ase.project.domain.action.Death;
import ase.project.domain.action.attack.BasicAttack;

public abstract class Character implements BasicAttack, Death {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;

    public Character(String name, int currentHealth, int maxHealth) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int takeDamage(int damage) {
        return currentHealth - damage;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
}
