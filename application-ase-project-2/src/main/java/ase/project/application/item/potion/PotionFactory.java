package ase.project.application.item.potion;

import ase.project.domain.item.Potion;

public class PotionFactory {
    public static Potion getPotion(PotionType potionType) {
        if (potionType == PotionType.HEALTH) {
            return new HealthPotion();
        } else if (potionType == PotionType.MANA) {
            return new ManaPotion();
        } else {
            throw new IllegalArgumentException("Invalid potion type: " + potionType);
        }
    }
}
