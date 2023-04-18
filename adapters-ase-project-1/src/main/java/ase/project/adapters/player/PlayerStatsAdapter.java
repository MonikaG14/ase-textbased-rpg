package ase.project.adapters.player;

import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;

public class PlayerStatsAdapter {

    private final PlayerStatsRepository playerStatsRepository;


    public PlayerStatsAdapter(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public PlayerStats getPlayerStats() {
        return playerStatsRepository.getPlayerStats();
    }

    public void savePlayerStats(PlayerStats playerStats) {
        playerStatsRepository.savePlayerStats(playerStats);
    }
}
