package ase.project.adapters.player;

import ase.project.application.player.classes.Astronomer;
import ase.project.application.player.classes.Busker;
import ase.project.application.player.classes.Gladiator;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PlayerClassFactory {

    private final Map<Integer, Supplier<Player>> CLASS_MAP = new HashMap<>();

    {
        CLASS_MAP.put(1, () -> new Astronomer("Astronomer", 40, 40, 20, 3, 2, 10));
        CLASS_MAP.put(2, () -> new Busker("Busker", 40, 40, 20, 3, 2, 10));
        CLASS_MAP.put(3, () -> new Gladiator("Gladiator", 40, 40, 20, 3, 2, 10));
    }

    public Player createPlayerClass(int classKey) {
        Supplier<Player> playerClass = CLASS_MAP.get(classKey);
        if(playerClass == null) {
            throw new IllegalArgumentException("Invalid class name. Try again.");
        }
        return playerClass.get();
    }

    public Map<Integer, Supplier<Player>> getCLASS_MAP() {
        return CLASS_MAP;
    }
}
