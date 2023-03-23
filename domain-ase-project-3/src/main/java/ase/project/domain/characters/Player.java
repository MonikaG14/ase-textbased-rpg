package ase.project.domain.characters;

public abstract class Player extends Character {
    protected int mana;
    protected int amountHealthPotions;
    protected int amountManaPotions;

    public Player(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth);
        this.mana = mana;
        this.amountHealthPotions = amountHealthPotions;
        this.amountManaPotions = amountManaPotions;
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