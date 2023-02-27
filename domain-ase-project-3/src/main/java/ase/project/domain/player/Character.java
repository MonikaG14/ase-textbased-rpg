package ase.project.domain.player;

import ase.project.domain.action.Death;
import ase.project.domain.action.attack.BasicAttack;
import ase.project.domain.action.attack.SpecialAttack;

public abstract class Character implements BasicAttack, SpecialAttack, Death {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int health;
    protected int maxHealth;
    protected String mana;

    public Character(String name, int strength, int dexterity, int health, int maxHealth, String mana) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.health = health;
        this.maxHealth = maxHealth;
        this.mana = mana;
    }

    public int takeDamage(int damage) {
        return this.health -= damage;
    }

    public boolean die() {
        return false;
    }

    public void useItem() {
    }
}