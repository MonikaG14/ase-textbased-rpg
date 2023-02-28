package ase.project.domain.npc;

import ase.project.domain.action.attack.BasicAttack;
import ase.project.domain.action.Death;

public abstract class Enemy implements BasicAttack, Death{
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int power;

    public Enemy(int health, int maxHealth, int power) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.power = power;
    }
    public void takeDamage(int damage){
        this.health -= damage;
    }

    //rest tbd
}