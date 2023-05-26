package ase.project.adapters.descriptions;

import ase.project.domain.action.DescriptionLoader;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.*;

public class DescriptionManager {

    private final DescriptionLoader descriptionLoader;
    private final InputProvider inputProvider;

    public DescriptionManager(DescriptionLoader descriptionLoader, InputProvider inputProvider) {
        this.descriptionLoader = descriptionLoader;
        this.inputProvider = inputProvider;
    }

    public void printStartingGame() {
        System.out.println(formatDescription(descriptionLoader.getDescription("starting1")));
        pressContinue();
        System.out.println(formatDescription(descriptionLoader.getDescription("starting2")));
        pressContinue();
        System.out.println(formatDescription(descriptionLoader.getDescription("starting3")));
        pressContinue();
        System.out.println(formatDescription(descriptionLoader.getDescription("starting4")));
        pressContinue();
    }

    public void printClassDescriptions() {
        System.out.println(formatDescription(descriptionLoader.getDescription("choose")));
        System.out.println();
        System.out.println(formatDescription(descriptionLoader.getDescription("astronomer")));
        pressContinue();
        System.out.println(formatDescription(descriptionLoader.getDescription("busker")));
        pressContinue();
        System.out.println(formatDescription(descriptionLoader.getDescription("gladiator")));
        pressContinue();
    }

    public String getWeaponDescription(String weaponKey) {
        return formatDescription(descriptionLoader.getDescription(weaponKey));
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
        pressContinue();
    }

    public String getEnemyDescription(String enemyKey) {
        System.out.println();
        pressContinue();
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

    public void printFirstLevelDescription() {
        System.out.println(formatDescription(descriptionLoader.getDescription("first_level1")));
        System.out.println(formatDescription(descriptionLoader.getDescription("first_level2")));
        System.out.println(formatDescription(descriptionLoader.getDescription("creatures")));
    }


    public void printEndFirstLevel() {
        System.out.println(formatDescription(descriptionLoader.getDescription("end_of_first_level")));
        pressContinue();
    }

    public void printLevelDescription(Level level) {
        System.out.println(formatDescription(level.getStartingLevelDescription()));
        System.out.println(formatDescription(descriptionLoader.getDescription("creatures")));
        pressContinue();
    }

    public void printFinalLevelDescription() {
        System.out.println(formatDescription(descriptionLoader.getDescription("final_level")));
        pressContinue();
    }

    public void printEndingGame() {
        System.out.println(formatDescription(descriptionLoader.getDescription("ending")));
    }

    public void pressContinue() {
        System.out.println("Press any button to continue...");
        inputProvider.readChar();
    }


    public String formatDescription(String description) {
        int maxWidth = 100;
        description = description.trim();

        String[] words = description.split("\\s+");

        StringBuilder formattedDescription = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        int currentWidth = 0;

        for (String word : words) {
            int wordWidth = word.length() + 1; // Add 1 for the space after the word

            if (currentWidth + wordWidth <= maxWidth) {
                currentLine.append(word).append(" ");
                currentWidth += wordWidth;
            } else {
                formattedDescription.append(currentLine).append(System.lineSeparator());
                currentLine = new StringBuilder(word).append(" ");
                currentWidth = wordWidth;
            }
        }

        formattedDescription.append(currentLine);

        return formattedDescription.toString();
    }
}
