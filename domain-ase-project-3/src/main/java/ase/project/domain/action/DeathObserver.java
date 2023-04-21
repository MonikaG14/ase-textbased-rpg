package ase.project.domain.action;

import ase.project.domain.characters.Character;

public interface DeathObserver {
    void onCharacterDeath(Character character);
}
