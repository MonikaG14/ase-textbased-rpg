package ase.project.adapters.player;

import ase.project.domain.characters.player.Player;
import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;

public class PlayerStatsAdapter {

    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsAdapter(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public void getPlayerStats(Player player) {
        playerStatsRepository.getPlayerStats(player);
    }

    public void savePlayerStats(PlayerStats playerStats) {
        playerStatsRepository.savePlayerStats(playerStats);
    }

    public void displayPlayerStats() {
        playerStatsRepository.displayPlayerStats();
    }
}
