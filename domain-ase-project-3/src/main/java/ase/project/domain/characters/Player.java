package ase.project.domain.characters;

public abstract class Player extends Character {
    protected int strength;
    protected int dexterity;
    protected String mana;

    public Player(String name, int currentHealth, int maxHealth, int strength, int dexterity, String mana) {
        super(name, currentHealth, maxHealth);
        this.strength = strength;
        this.dexterity = dexterity;
        this.mana = mana;
    }

    public int takeDamage(int damage) {
        return currentHealth - damage;
    }

    public boolean die() {
        return false;
    }

    public void useItem() {
    }
}