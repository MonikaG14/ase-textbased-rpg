package ase.project.application.item.weapon;

import ase.project.domain.item.Item;
import ase.project.domain.item.Weapon;

public class Staff extends Item implements Weapon {

    public final String keyToDescription  = "makeshift_staff";

    @Override
    public int getDamage() {
        return 10;
    }
}