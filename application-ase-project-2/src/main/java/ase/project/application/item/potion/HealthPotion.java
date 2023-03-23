package ase.project.application.item.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class HealthPotion implements Potion {
    @Override
    public String getDescription() {
        return "Health Potion";
    }

    @Override
    public int drink(Player player) {
        return player.getCurrentHealth() + 20;
    }
}
