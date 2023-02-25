package ase.project.domain.action;

import ase.project.domain.npc.Enemy;

public interface Attack {
    void basicAttack(Enemy target);
    void specialAttack(Enemy target, String attackName);
}

