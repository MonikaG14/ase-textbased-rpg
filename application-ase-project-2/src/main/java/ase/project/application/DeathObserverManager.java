package ase.project.application;

import ase.project.domain.action.DeathObserver;
import ase.project.domain.characters.Character;
import ase.project.domain.level.Level;

public class DeathObserverManager {

    public void notifyObserver(Character character, Level level) {
        DeathObserver deathObserver = new Death(level);
        deathObserver.onCharacterDeath(character);
    }

    public void checkIfDead(Character character, Level level) {
        if (character.isDead()) {
            this.notifyObserver(character, level);
        }
    }
}
