package ase.project.adapters.player;

import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.player.Player;

import java.util.Map;
import java.util.function.Supplier;

public class PlayerClassManager {

    private final InputProvider inputProvider;
    private final PlayerClassFactory playerClassFactory = new PlayerClassFactory();

    public PlayerClassManager(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Player chooseClass() {
        this.iterateClasses();
        int classKey = inputProvider.readInt();

        try {
            Player player = playerClassFactory.createPlayerClass(classKey);
            System.out.println("You chose the class " + player.getClass().getSimpleName());
            return player;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Invalid choice. Try again.");
            return chooseClass();
        }
    }

    public void iterateClasses() {
        System.out.println("Choose your class: ");
        Map<Integer, Supplier<Player>> classes = playerClassFactory.getCLASS_MAP();
        for (Map.Entry<Integer, Supplier<Player>> entry : classes.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().get().getName());
        }
    }
}
