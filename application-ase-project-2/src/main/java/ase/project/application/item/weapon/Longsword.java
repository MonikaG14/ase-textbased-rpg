package ase.project.application.item.weapon;

import ase.project.domain.item.Item;
import ase.project.domain.item.Weapon;

public class Longsword extends Item implements Weapon {

    public final String keyToDescription = "cursed_longsword";

    @Override
    public int getDamage() {
        return 10;
    }
}
