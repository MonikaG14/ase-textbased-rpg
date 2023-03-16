package ase.project.domain.action.attack;

import ase.project.domain.characters.Character;

public interface SpecialAttack {
    void performSpecialAttack(Character target, String attackName);
    int getManaCost();
    String getDescription();
}
