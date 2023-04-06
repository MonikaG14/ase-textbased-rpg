package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class HealthPotion implements Potion {
    @Override
    public String getItemDescription() {
        return "Health Potion";
    }

    @Override
    public Player drink(Player player) {
        player.reduceAmountOfHealthPotions();
        player.gainHealth(20);
        return player;
    }
}
