package ase.project.application.action;

import ase.project.application.item.potion.PotionFactory;
import ase.project.application.item.potion.PotionType;
import ase.project.application.player.PlayerClass;
import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class PotionService {

    public static Potion choosePotionType(PotionType potionType) {
        return PotionFactory.getPotion(potionType);
    }

    public static void checkAmountOfPotions(Integer amount) {
        if (amount == null) {
            throw new IllegalArgumentException("No potions left!");
        }
    }

    public static Player usePotion(String potionType, PlayerClass player) {
        PotionType type = PotionType.valueOf(potionType.toUpperCase());
        Potion potion = choosePotionType(type);

        checkAmountOfPotions(player.getAmountOfPotionType().get(type));

        player.updateAmountOfPotionType(type, player);

        return potion.drink(player);
    }
}
