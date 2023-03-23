package ase.project.domain.item;

import ase.project.domain.characters.Player;

public interface Potion extends Item {
    int drink(Player player);
}
