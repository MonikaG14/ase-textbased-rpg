package ase.project.domain.player;

import ase.project.domain.action.Attack;
import ase.project.domain.action.Death;
import ase.project.domain.action.Moveable;

public abstract class Character implements Attack, Death, Moveable {
    protected int intelligence;
    protected int strength;
    protected int dexterity;
    protected int health;
    protected int maxHealth;

    public Character(int intelligence, int strength, int dexterity, int health, int maxHealth) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.dexterity = dexterity;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public int takeDamage(int damage) {
        return this.health -= damage;
    }


}