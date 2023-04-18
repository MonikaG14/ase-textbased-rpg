package ase.project.domain.characters.player;

import ase.project.domain.characters.Character;

public class PlayerStats extends Player {

    public PlayerStats(int playerId, String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        playerId = this.getId();
    }

    @Override
    public void useBasicAttack(Character target) {
    }
}
