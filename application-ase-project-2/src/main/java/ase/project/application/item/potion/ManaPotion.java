package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class ManaPotion implements Potion {
    @Override
    public String getDescription() {
        return "Mana Potion";
    }

    @Override
    public int drink(Player player) {
        return player.getMana() + 10;
    }
}
