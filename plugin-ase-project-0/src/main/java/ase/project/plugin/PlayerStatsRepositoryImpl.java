package ase.project.plugin;

import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;

import java.io.*;
import java.util.Scanner;

public class PlayerStatsRepositoryImpl implements PlayerStatsRepository {

    private final String FILENAME = "playerStats.txt";

    @Override
    public PlayerStats getPlayerStats() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {

            int id = scanner.nextInt();
            String playerName = scanner.nextLine();
            int currentHealth = scanner.nextInt();
            int maxHealth = scanner.nextInt();
            int mana = scanner.nextInt();
            int amountHealthPotions = scanner.nextInt();
            int amountManaPotions = scanner.nextInt();

            return new PlayerStats(id, playerName, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read player stats", e);
        }
    }

    @Override
    public void savePlayerStats(PlayerStats playerStats) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            writer.println((playerStats.getId()));
            writer.println(playerStats.getName());
            writer.println(playerStats.getCurrentHealth());
            writer.println(playerStats.getMaxHealth());
            writer.println(playerStats.getMana());
            writer.println(playerStats.getAmountHealthPotions());
            writer.println(playerStats.getAmountManaPotions());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save player stats", e);
        }
    }
}
