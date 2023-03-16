package ase.project.application.action;

import ase.project.application.exception.InvalidManaException;

public class Mana {
    public static boolean checkMana(int mana, int manaCost) {
        try {
            if (mana - manaCost < 0) {
                throw new InvalidManaException("You do not have enough mana for this attack!");
            }
        } catch (InvalidManaException exception) {
            System.out.println(exception.getMessage());
        }
        return true;
    }

    public static int useMana(int mana, int manaCost) {
        return mana - manaCost;
    }
}
