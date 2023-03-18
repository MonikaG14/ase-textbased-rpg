package ase.project.application.action;

import ase.project.application.exception.InvalidManaException;

public class Mana {
    public static void checkMana(int mana, int manaCost) throws InvalidManaException {
        if (mana - manaCost < 0) {
            throw new InvalidManaException("You do not have enough mana for this attack!");
        }
    }

    public static int useMana(int mana, int manaCost) {
        mana -= manaCost;
        return mana;
    }
}
