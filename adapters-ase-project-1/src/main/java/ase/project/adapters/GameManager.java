package ase.project.adapters;

import ase.project.adapters.descriptions.DescriptionLoaderImpl;
import ase.project.adapters.descriptions.DescriptionManager;
import ase.project.adapters.input.ScannerInputProvider;
import ase.project.adapters.level.LevelManager;
import ase.project.adapters.player.PlayerClassManager;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.PlayerManager;
import ase.project.domain.action.DescriptionLoader;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.player.PlayerStatsRepository;
import ase.project.domain.level.Level;

public class GameManager {

    private final DescriptionLoader descriptionLoader = new DescriptionLoaderImpl();
    private final PlayerStatsRepository playerStatsRepository;
    private Level level;
    private PlayerManager player;
    private GameCombatManager gameCombatManager;
    private final InputProvider inputProvider = new ScannerInputProvider();
    private final DescriptionManager descriptionManager = new DescriptionManager(descriptionLoader, inputProvider);
    private final LevelManager levelManager = new LevelManager(descriptionManager);
    public GameManager(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public void startGame() throws InvalidAttackException {
        descriptionManager.printStartingGame();
        runFirstLevel();
        runNextLevel();
    }

    public void runFirstLevel() {
        descriptionManager.printClassDescriptions();

        PlayerClassManager playerClassManager = new PlayerClassManager(inputProvider);
        player = (PlayerManager) playerClassManager.chooseClass();

        level = levelManager.generateFirstLevel(player);
    }

    public void runNextLevel() throws InvalidAttackException {
        level = levelManager.generateNextLevel();
        gameCombatManager = new GameCombatManager(player, level.getEnemies(), playerStatsRepository, inputProvider, level);

        if (gameCombatManager.startCombat()) {
            runFinalLevel();
        }
    }

    public void runFinalLevel() throws InvalidAttackException {
        level = levelManager.generateFinalLevel();
        gameCombatManager = new GameCombatManager(player, level.getEnemies(), playerStatsRepository, inputProvider, level);

        gameCombatManager.startCombat();

        descriptionManager.printEndingGame();
    }
}
