package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Item;
import ase.project.domain.item.Potion;

public class HealthPotion extends Item implements Potion {

    public final String keyToDescription  = "health_potion";

    @Override
    public Player drink(Player player) {
        player.reduceAmountOfHealthPotions();
        player.gainHealth(20);
        return player;
    }
}
