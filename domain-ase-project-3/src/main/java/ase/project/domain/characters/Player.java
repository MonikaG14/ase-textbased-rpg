package ase.project.domain.characters;

public abstract class Player extends Character {
    protected int mana;

    public Player(String name, int currentHealth, int maxHealth, int mana) {
        super(name, currentHealth, maxHealth);
        this.mana = mana;
    }

    public int takeDamage(int damage) {
        return currentHealth - damage;
    }

    public boolean die() {
        return false;
    }

    public int getMana() {
        return mana;
    }
}