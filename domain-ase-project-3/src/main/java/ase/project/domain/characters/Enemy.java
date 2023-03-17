package ase.project.domain.characters;

public abstract class Enemy extends Character {
    protected int power;

    public Enemy(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth);
        this.power = power;
    }
    //ToDo EnemyID
}
