package ase.project.adapters;

import ase.project.adapters.input.ScannerInputProvider;
import ase.project.adapters.player.PlayerClassManager;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.DescriptionLoader;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.player.PlayerStatsRepository;
import ase.project.domain.level.Level;

public class GameManager {

    private final DescriptionLoader descriptionLoader;
    private final PlayerStatsRepository playerStatsRepository;
    private Level level;
    private PlayerManager player;
    private GameCombatManager gameCombatManager;
    private final InputProvider inputProvider = new ScannerInputProvider();
    private final LevelManager levelManager = new LevelManager();

    public GameManager(DescriptionLoader descriptionLoader, PlayerStatsRepository playerStatsRepository) {
        this.descriptionLoader = descriptionLoader;
        this.playerStatsRepository = playerStatsRepository;
    }

    public void startGame() throws InsufficientManaException, InvalidAttackException {
        runFirstLevel();
        runNextLevel();
    }

    public void runFirstLevel() {
        PlayerClassManager playerClassManager = new PlayerClassManager(inputProvider);
        player = (PlayerManager) playerClassManager.chooseClass();
        level = levelManager.generateFirstLevel();
    }

    public void runNextLevel() throws InsufficientManaException, InvalidAttackException {
        level = levelManager.generateNextLevel();
        gameCombatManager = new GameCombatManager(player, level.getEnemies(), playerStatsRepository, inputProvider, level);

        if (gameCombatManager.startCombat()) {
            runFinalLevel();
        }
    }

    public void runFinalLevel() throws InsufficientManaException, InvalidAttackException {
        level = levelManager.generateFinalLevel();
        gameCombatManager = new GameCombatManager(player, level.getEnemies(), playerStatsRepository, inputProvider, level);

        gameCombatManager.startCombat();

        descriptionLoader.getDescription("end_description");
        System.out.println("Congratulations! You won!");
    }
}
