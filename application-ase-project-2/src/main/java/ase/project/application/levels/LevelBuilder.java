package ase.project.application.levels;

import ase.project.application.enemies.EnemyFactory;
import ase.project.domain.characters.Enemy;
import ase.project.domain.item.Item;
import ase.project.domain.level.Level;

import java.util.List;
import java.util.Map;

public class LevelBuilder extends Level {

    private int numberOfEnemies;
    private final EnemyFactory enemyFactory;
    private final LevelDescriptionGenerator levelDescriptionGenerator;

    public LevelBuilder(Map<Integer, Enemy> enemies, List<Item> items, String startingDescription, int numberOfEnemies) {
        super(enemies, items, startingDescription);
        this.numberOfEnemies = numberOfEnemies;
        this.enemyFactory = new EnemyFactory();
        this.levelDescriptionGenerator = new LevelDescriptionGenerator();
    }

    public LevelBuilder getNumberOfEnemies(int count) {
        numberOfEnemies = count;
        return this;
    }

    public LevelBuilder getEnemies(int numberOfEnemies) {
        enemies = enemyFactory.createRandomEnemies(numberOfEnemies);
        return this;
    }

    public LevelBuilder getLevelDescription() {
        startingLevelDescription = levelDescriptionGenerator.generateDescription();
        return this;
    }

    public Level build() {
        return new LevelBuilder(enemies, items, startingLevelDescription, numberOfEnemies);
    }
}