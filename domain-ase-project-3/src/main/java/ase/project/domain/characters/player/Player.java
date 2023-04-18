package ase.project.domain.characters.player;

import ase.project.domain.characters.Character;

public abstract class Player extends Character {
    protected int id;
    protected PlayerId playerId = new PlayerId();
    protected int mana;
    protected int amountHealthPotions;
    protected int amountManaPotions;

    public Player(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth);
        this.id = playerId.getId();
        this.mana = mana;
        this.amountHealthPotions = amountHealthPotions;
        this.amountManaPotions = amountManaPotions;
    }

    public Player reduceAmountOfHealthPotions() {
        amountHealthPotions --;
        return this;
    }

    public Player reduceAmountOfManaPotions() {
        amountManaPotions --;
        return this;
    }

    public Player gainHealth(int amountHealthGain) {
        currentHealth += amountHealthGain;
        return this;
    }

    public Player gainMana(int amountManaGain) {
        mana += amountManaGain;
        return this;
    }

    public int getId() {
        return playerId.getId();
    }

    public int getMana() {
        return mana;
    }


    public int getAmountHealthPotions() {
        return amountHealthPotions;
    }

    public int getAmountManaPotions() {
        return amountManaPotions;
    }

    public Player getPlayer() {
        return this;
    }
}