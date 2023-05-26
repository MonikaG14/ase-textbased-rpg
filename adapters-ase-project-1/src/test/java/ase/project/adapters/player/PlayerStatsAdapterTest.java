package ase.project.adapters.player;

import ase.project.application.player.classes.Gladiator;
import ase.project.domain.characters.player.Player;
import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlayerStatsAdapterTest {
    @Mock
    private PlayerStatsRepository mockPlayerStatsRepository;

    private PlayerStatsAdapter playerStatsAdapter;

    private final PlayerStats expectedPlayerStats = new PlayerStats(1, "John Doe", 100, 100, 50, 10, 5);

    @BeforeEach
    public void setUp() {
        mockPlayerStatsRepository = mock(PlayerStatsRepository.class);
        playerStatsAdapter = new PlayerStatsAdapter(mockPlayerStatsRepository);
    }

    @Test
    public void testGetPlayerStats() {
        Player player = new Gladiator( "Test Player", 100, 100, 50, 5, 3, 10);
        PlayerStats expectedPlayerStats = new PlayerStats(player.getId(), player.getName(), player.getCurrentHealth(), player.getMaxHealth(), player.getMana(), player.getAmountHealthPotions(), player.getAmountManaPotions());

        playerStatsAdapter.getPlayerStats(player);

        verify(mockPlayerStatsRepository).getPlayerStats(player);
    }

    @Test
    public void testSavePlayerStats() {
        playerStatsAdapter.savePlayerStats(expectedPlayerStats);

        verify(mockPlayerStatsRepository).savePlayerStats(expectedPlayerStats);
    }
}