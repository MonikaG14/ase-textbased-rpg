package ase.project.domain.characters.enemy;

import ase.project.domain.characters.Character;

import java.util.Objects;

public abstract class Enemy extends Character {

    protected int power;
    protected String enemyDescription;

    public Enemy(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth);
        this.power = power;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void dies() {
        System.out.println("Congratulations! " + this.getName() + " died!");
    }
}
