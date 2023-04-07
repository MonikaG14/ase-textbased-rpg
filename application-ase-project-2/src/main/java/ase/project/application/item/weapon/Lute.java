package ase.project.application.item.weapon;

import ase.project.domain.item.Item;
import ase.project.domain.item.Weapon;

public class Lute extends Item implements Weapon {

    public final String keyToDescription = "the_lute-nuke";

    @Override
    public String getNameOfWeapon() {
        String nameOfWeapon = "The Lute-nuke";
        return nameOfWeapon;
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
