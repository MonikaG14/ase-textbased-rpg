package ase.project.domain.characters.enemy;

import ase.project.domain.characters.Character;

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
}
