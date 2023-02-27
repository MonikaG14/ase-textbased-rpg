package ase.project.domain.action.attack;

import ase.project.domain.npc.Enemy;

public interface SpecialAttack {
    void useSpecialAttack(Enemy target, String attackName, int attribute);
}
