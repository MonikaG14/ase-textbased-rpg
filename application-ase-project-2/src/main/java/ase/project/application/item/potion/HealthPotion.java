package ase.project.application.item.potion;

import ase.project.domain.item.Potion;

public class HealthPotion implements Potion {
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int drink(int health) {
        return health + 20;
    }
}