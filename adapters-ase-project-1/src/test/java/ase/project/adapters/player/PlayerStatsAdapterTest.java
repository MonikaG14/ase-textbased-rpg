package ase.project.adapters.player;

import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        when(mockPlayerStatsRepository.getPlayerStats()).thenReturn(expectedPlayerStats);

        PlayerStats actualPlayerStats = playerStatsAdapter.getPlayerStats();

        assertEquals(expectedPlayerStats, actualPlayerStats);
        verify(mockPlayerStatsRepository).getPlayerStats();
    }

    @Test
    public void testSavePlayerStats() {
        playerStatsAdapter.savePlayerStats(expectedPlayerStats);

        verify(mockPlayerStatsRepository).savePlayerStats(expectedPlayerStats);
    }
}