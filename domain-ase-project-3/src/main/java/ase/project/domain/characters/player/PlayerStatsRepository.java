package ase.project.domain.characters.player;

public interface PlayerStatsRepository {
    PlayerStats getPlayerStats();
    void savePlayerStats(PlayerStats playerStats);
}
