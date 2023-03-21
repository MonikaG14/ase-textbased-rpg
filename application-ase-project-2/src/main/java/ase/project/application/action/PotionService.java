package ase.project.application.action;

import ase.project.application.item.potion.PotionFactory;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.item.Potion;

public class PotionService {
    public static Potion choosePotion(PotionType potionType) {
        return PotionFactory.getPotion(potionType);
    }

    public static void checkAmountOfPotions(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("No potions left!");
        }
    }
}
