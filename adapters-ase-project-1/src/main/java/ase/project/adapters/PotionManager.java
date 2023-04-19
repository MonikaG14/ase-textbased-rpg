package ase.project.adapters;

import ase.project.application.item.potion.PotionType;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.InputProvider;

import java.util.HashMap;
import java.util.Map;

public class PotionManager {

    private final InputProvider inputProvider;

    private static final Map<Integer, PotionType> POTION_TYPE_MAP = new HashMap<>();
    static {
        for (PotionType type : PotionType.values()) {
            POTION_TYPE_MAP.put(type.ordinal() + 1, type);
        }
    }

    public PotionManager(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void choosePotionType(PlayerManager player) {
        this.iteratePotionTypes();
        int choice = inputProvider.readInt();

        String potionType = POTION_TYPE_MAP.get(choice).toString();

        player.drink(potionType, player);
    }

    public void iteratePotionTypes() {
        System.out.println("Choose a potion type: ");
        for (int i = 0; i < PotionType.values().length; i++) {
            System.out.println((i + 1) + ": " + PotionType.values()[i].name());
        }
    }
}
