package ase.project.application.action.potion;

import ase.project.domain.characters.player.Player;
import ase.project.domain.item.Potion;

public class DrinkPotionService {
    public Player drinkPotion(Potion potion, Player player) {
        return potion.drink(player);
    }
}
