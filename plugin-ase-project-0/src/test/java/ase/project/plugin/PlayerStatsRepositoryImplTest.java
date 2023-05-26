package ase.project.plugin;

import ase.project.application.player.classes.Busker;
import ase.project.domain.characters.player.Player;
import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerStatsRepositoryImplTest {

    private static final String FILENAME = "playerStats.txt";
    private PlayerStatsRepository playerStatsRepository;

    @BeforeEach
    void setUp() {
        playerStatsRepository = new PlayerStatsRepositoryImpl();
    }

    @Test
    void testSavePlayerStats() {
        PlayerStats playerStats = new PlayerStats(1, "Player1", 100, 200, 50, 3, 2);

        playerStatsRepository.savePlayerStats(playerStats);

        File file = new File(FILENAME);
        assertTrue(file.exists());
    }

    @Test
    void testGetPlayerStats() {
        Player player = new Busker("Player1", 100, 200, 50, 3, 2, 10);

        playerStatsRepository.getPlayerStats(player);

        File file = new File(FILENAME);
        assertTrue(file.exists());
    }
}