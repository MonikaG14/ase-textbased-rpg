package ase.project.application.action.potion;

import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class PotionUsageService {
    public Player usePotion(Potion potion, Player player) {
        return potion.drink(player);
    }
}
