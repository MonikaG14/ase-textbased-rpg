package ase.project.domain.npc;

import ase.project.domain.action.Attack;
import ase.project.domain.action.Death;

public abstract class Enemy implements Attack, Death {
    protected int health;
    protected int maxHealth;
    protected int power;

    public Enemy(int health, int maxHealth, int power) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.power = power;
    }
    //rest tbd
}
