package ase.project.adapters.player;

import ase.project.adapters.potion.PotionManager;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.player.PlayerStatsRepository;
import ase.project.domain.level.Level;

public class PlayerActionManager {

    private final PlayerCombatManager playerCombatManager;
    private final PotionManager potionManager;
    private final PlayerStatsAdapter playerStatsAdapter;
    private final InputProvider inputProvider;

    public PlayerActionManager(PlayerStatsRepository playerStatsRepository, InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        this.playerCombatManager = new PlayerCombatManager(inputProvider);
        this.potionManager = new PotionManager(inputProvider);
        this.playerStatsAdapter = new PlayerStatsAdapter(playerStatsRepository);
    }

    public void chooseAction(PlayerManager player, Level level) throws InvalidAttackException {
        this.iterateMessages();
        int choice;

        do {
            choice = inputProvider.readInt();
            if (choice == 1) {
                performAttackAction(player, level);
            } else if (choice == 2) {
                performPotionAction(player);
            } else if (choice == 3) {
                performStatsAction(player);
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice < 1 || choice > 3);
    }

    private void performAttackAction(PlayerManager player, Level level) throws InvalidAttackException {
        playerCombatManager.chooseBetweenSpecialAndBasicAttack(player, level);
    }

    private void performPotionAction(PlayerManager player) {
        try {
            potionManager.choosePotionType(player);
        } catch (NullPointerException e) {
            System.out.println("Invalid choice. Please choose again.");
        }
    }

    private void performStatsAction(PlayerManager player) {
        playerStatsAdapter.getPlayerStats(player);
        playerStatsAdapter.displayPlayerStats();
        System.out.println();
    }


    public void iterateMessages() {
        System.out.println();
        System.out.println("Think carefully. You can only choose once!");
        System.out.println("You can choose between: ");
        System.out.println("1. Attacking");
        System.out.println("2. Using a potion");
        System.out.println("3. Checking your stats");
    }
}
