package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class ManaPotion implements Potion {
    @Override
    public String getItemDescription() {
        return "Mana Potion";
    }

    @Override
    public Player drink(Player player) {
        player.reduceAmountOfManaPotions();
        player.gainMana(10);
        return player;
    }
}
