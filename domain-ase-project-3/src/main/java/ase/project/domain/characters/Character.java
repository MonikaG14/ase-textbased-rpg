package ase.project.domain.characters;

import ase.project.domain.action.Death;
import ase.project.domain.action.attack.BasicAttack;
import ase.project.domain.action.attack.SpecialAttack;

public abstract class Character implements BasicAttack, SpecialAttack, Death {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;

    public Character(String name, int currentHealth, int maxHealth) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int takeDamage(int damage){
        return currentHealth - damage;
    }
}
