package ase.project.domain.characters;

import ase.project.domain.dice.DiceRoller;

import static ase.project.domain.dice.DiceRoller.rollDice;

public abstract class Enemy extends Character {
    protected int power;

    public Enemy(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth);
        this.power = power;
    }
    //ToDo EnemyID
}
