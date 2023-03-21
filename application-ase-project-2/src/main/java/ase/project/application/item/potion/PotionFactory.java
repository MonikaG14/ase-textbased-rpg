package ase.project.application.item.potion;

import ase.project.domain.item.Potion;

public class PotionFactory {
    public static Potion getHealthPotion() {
        return new HealthPotion();
    }

    public static Potion getManaPotion() {
        return new ManaPotion();
    }
}
