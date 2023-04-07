package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Item;
import ase.project.domain.item.Potion;

public class ManaPotion extends Item implements Potion {

    public final String keyToDescription  = "mana_potion";

    @Override
    public Player drink(Player player) {
        player.reduceAmountOfManaPotions();
        player.gainMana(10);
        return player;
    }
}
