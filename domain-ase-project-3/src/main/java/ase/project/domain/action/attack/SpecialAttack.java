package ase.project.domain.action.attack;

import ase.project.domain.characters.Character;

public interface SpecialAttack {

    void performSpecialAttack(Character target);
    int getManaCost();
    String getKeyToDescription();
}
