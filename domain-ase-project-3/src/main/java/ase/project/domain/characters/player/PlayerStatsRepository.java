package ase.project.domain.characters.player;

public interface PlayerStatsRepository {
    void getPlayerStats(Player player);
    void savePlayerStats(PlayerStats playerStats);
    void displayPlayerStats();
}
