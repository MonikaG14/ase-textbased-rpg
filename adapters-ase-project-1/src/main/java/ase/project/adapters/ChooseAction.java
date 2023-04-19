package ase.project.adapters;

import ase.project.adapters.player.PlayerStatsAdapter;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.InputProvider;
import ase.project.domain.level.Level;

public class ChooseAction {

    private final CombatManager combatManager;
    private final PotionManager potionManager;
    private final PlayerStatsAdapter playerStatsAdapter;

    private final InputProvider inputProvider;

    public ChooseAction(CombatManager combatManager, PotionManager potionManager, PlayerStatsAdapter playerStatsAdapter, InputProvider inputProvider) {
        this.combatManager = combatManager;
        this.potionManager = potionManager;
        this.playerStatsAdapter = playerStatsAdapter;
        this.inputProvider = inputProvider;
    }

    public void chooseAction(PlayerManager player, Level level) throws InsufficientManaException, InvalidAttackException {
        this.iterateMessages();
        int choice;

        do {
            choice = inputProvider.readInt();
            if (choice == 1) {
                combatManager.chooseBetweenSpecialAndBasicAttack(player, level);
            } else if (choice == 2) {
                potionManager.choosePotionType(player);
            } else if (choice == 3){
                playerStatsAdapter.getPlayerStats();
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice < 1 || choice > 3);

    }

    public void iterateMessages() {
        System.out.println("Think carefully. You can only choose once!");
        System.out.println("You can choose between: ");
        System.out.println("1. Attacking");
        System.out.println("2. Using a potion");
        System.out.println("3. Checking your stats");
    }
}
