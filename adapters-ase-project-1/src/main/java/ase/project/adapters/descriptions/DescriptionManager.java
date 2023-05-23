package ase.project.adapters.descriptions;

import ase.project.domain.action.DescriptionLoader;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.*;

public class DescriptionManager {
    private final DescriptionLoader descriptionLoader;

    public DescriptionManager(DescriptionLoader descriptionLoader) {
        this.descriptionLoader = descriptionLoader;
    }

    public String getWeaponDescription(String weaponKey) {
        return formatDescription(descriptionLoader.getDescription(weaponKey));
    }

    public String getEnemyDescription(String enemyKey) {
        return formatDescription(descriptionLoader.getDescription(enemyKey));
    }

    public void printUniqueEnemyDescriptions(Map<Integer, Enemy> enemies) {
        Set<String> uniqueEnemyKeys = new HashSet<>();
        List<Enemy> uniqueEnemies = new ArrayList<>();

        for (Enemy enemy : enemies.values()) {
            String enemyKey = enemy.getKeyToDescription();

            if (!uniqueEnemyKeys.contains(enemyKey)) {
                uniqueEnemyKeys.add(enemyKey);
                uniqueEnemies.add(enemy);
            }
        }

        for (Enemy enemy : uniqueEnemies) {
            String enemyDescription = getEnemyDescription(enemy.getKeyToDescription());
            System.out.println(formatDescription(enemyDescription));
        }
        System.out.println();
    }

    public void printPlayerWeaponDescription(String playerClass) {
        Map<String, String> playerWeaponMapping = new HashMap<>();
        playerWeaponMapping.put("Gladiator", "cursed_longsword");
        playerWeaponMapping.put("Busker", "the_lute-nuke");
        playerWeaponMapping.put("Astronomer", "makeshift_staff");

        String weaponKey = playerWeaponMapping.get(playerClass);
        if (weaponKey == null) {
            throw new IllegalArgumentException("Invalid player class: " + playerClass);
        }

        String weaponDescription = getWeaponDescription(weaponKey);
        System.out.println(formatDescription(weaponDescription));
        System.out.println();
    }

    public void printLevelDescription(Level level) {
        System.out.println(formatDescription(level.getStartingLevelDescription()));
        System.out.println();
    }

    public void printFirstLevelDescription() {
        System.out.println(formatDescription(descriptionLoader.getDescription("first_level")));
    }

    public void printFinalLevelDescription() {
        System.out.println(formatDescription(descriptionLoader.getDescription("final_level")));
        System.out.println();
    }

    public void printEndingGame() {
        System.out.println(formatDescription(descriptionLoader.getDescription("ending")));
        System.out.println();
    }

    public void printClassDescriptions() {
        System.out.println(formatDescription(descriptionLoader.getDescription("astronomer")));
        System.out.println();
        System.out.println(formatDescription(descriptionLoader.getDescription("busker")));
        System.out.println();
        System.out.println(formatDescription(descriptionLoader.getDescription("gladiator")));
        System.out.println();
    }

    public String formatDescription(String description) {
        // Remove leading and trailing whitespaces
        int maxWidth = 100;
        description = description.trim();

        // Split the description into words
        String[] words = description.split("\\s+");

        StringBuilder formattedDescription = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        int currentWidth = 0;

        // Process each word
        for (String word : words) {
            int wordWidth = word.length() + 1; // Add 1 for the space after the word

            if (currentWidth + wordWidth <= maxWidth) {
                // Add the word to the current line
                currentLine.append(word).append(" ");
                currentWidth += wordWidth;
            } else {
                // Start a new line with the word
                formattedDescription.append(currentLine).append(System.lineSeparator());
                currentLine = new StringBuilder(word).append(" ");
                currentWidth = wordWidth;
            }
        }

        // Append the last line
        formattedDescription.append(currentLine);

        return formattedDescription.toString();
    }
}
