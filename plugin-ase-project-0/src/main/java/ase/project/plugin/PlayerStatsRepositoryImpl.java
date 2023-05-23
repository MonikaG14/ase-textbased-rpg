package ase.project.plugin;

import ase.project.domain.characters.player.Player;
import ase.project.domain.characters.player.PlayerStats;
import ase.project.domain.characters.player.PlayerStatsRepository;

import java.io.*;
import java.util.Scanner;

public class PlayerStatsRepositoryImpl implements PlayerStatsRepository {

    private final String FILENAME = "playerStats.txt";

    @Override
    public void getPlayerStats(Player player) {
        PlayerStats playerStats = new PlayerStats(
                player.getId(),
                player.getName(),
                player.getCurrentHealth(),
                player.getMaxHealth(),
                player.getMana(),
                player.getAmountHealthPotions(),
                player.getAmountManaPotions()
        );
        savePlayerStats(playerStats);
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

    @Override
    public void displayPlayerStats() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            System.out.println("Player Stats:");
            System.out.println("ID: " + scanner.nextLine());
            System.out.println("Class: " + scanner.nextLine());
            System.out.println("Current Health: " + scanner.nextLine());
            System.out.println("Max Health: " + scanner.nextLine());
            System.out.println("Mana: " + scanner.nextLine());
            System.out.println("Health Potions: " + scanner.nextLine());
            System.out.println("Mana Potions: " + scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read player stats", e);
        }
    }
}
