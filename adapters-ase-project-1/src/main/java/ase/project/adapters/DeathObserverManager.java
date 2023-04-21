package ase.project.adapters;

import ase.project.application.action.Death;
import ase.project.domain.action.DeathObserver;
import ase.project.domain.characters.Character;
import ase.project.domain.level.Level;

public class DeathObserverManager {

    private DeathObserver deathObserver;

    public void registerObserver(DeathObserver observer) {
        this.deathObserver = observer;
    }

    public void removeObserver() {
        this.deathObserver = null;
    }

    public void notifyObserver(Character character) {
        if (deathObserver != null) {
            deathObserver.onCharacterDeath(character);
        }
    }

    public void checkIfDead(Character character, Level level) {
        deathObserver = new Death(level);
        if (character.isDead()) {
            this.notifyObserver(character);
        }
    }
}
