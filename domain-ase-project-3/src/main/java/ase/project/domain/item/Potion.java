package ase.project.domain.item;

import ase.project.domain.characters.Player;

public interface Potion extends Item {
    Player drink(Player player);
}
