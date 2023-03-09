package ase.project.domain.action.attack;

import ase.project.domain.characters.Character;

public interface SpecialAttack {
    void useSpecialAttack(Character target, String attackName, int attribute);
}
