package ase.project.adapters;

import ase.project.application.player.classes.Astronomer;
import ase.project.application.player.classes.Busker;
import ase.project.application.player.classes.Gladiator;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class ChooseClass {

    private final Scanner scanner;
    private Map<Integer, Supplier<Player>> classMap = new HashMap<>();

    public ChooseClass(Scanner scanner) {
        this.scanner = scanner;
    }


    public Player chooseClass() {
        this.addClasses();
        this.iterateClasses();
        Supplier<Player> playerSupplier = this.getChoice();

        if(playerSupplier == null) {
            System.out.println("Invalid choice. Try again.");
            return chooseClass();
        }
        System.out.println("You chose " + playerSupplier.get().toString());
        return playerSupplier.get();
    }

    public void addClasses() {
        classMap.put(1, () -> new Astronomer("Astronomer", 40, 40, 20, 3, 2,10));
        classMap.put(2, () -> new Busker("Busker", 40, 40, 20, 3, 2, 10));
        classMap.put(3, () -> new Gladiator("Gladiator", 40, 40, 20,3, 2, 10));
    }

    public void iterateClasses() {
        System.out.println("Choose your class: ");
        for (Map.Entry<Integer, Supplier<Player>> entry : classMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().get().getName());
        }
    }

    public Supplier<Player> getChoice() {
        int choice = scanner.nextInt();
        return classMap.get(choice);
    }
}
