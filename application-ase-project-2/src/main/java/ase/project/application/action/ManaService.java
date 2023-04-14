package ase.project.application.action;

import ase.project.application.exception.InsufficientManaException;

public class ManaService {
    public static void checkMana(int mana, int manaCost) throws InsufficientManaException {
        if (mana - manaCost < 0) {
            throw new InsufficientManaException("You do not have enough mana for this attack!");
        }
    }

    public static int useMana(int mana, int manaCost) {
        mana -= manaCost;
        return mana;
    }
}
