package ase.project.application.levels;

import ase.project.application.enemies.EnemyFactory;
import ase.project.domain.characters.Enemy;
import ase.project.domain.item.Item;
import ase.project.domain.level.Level;

import java.util.List;

public class LevelBuilder extends Level {
    private int numberOfEnemies;
    private final EnemyFactory enemyFactory;
    private final LevelDescriptionGenerator levelDescriptionGenerator;
    private List<Enemy> enemies;

    public LevelBuilder(List<Item> items, String startingDescription, int numberOfEnemies, List<Enemy> enemies) {
        super(enemies, items, startingDescription);
        this.numberOfEnemies = numberOfEnemies;
        this.enemyFactory = new EnemyFactory();
        this.levelDescriptionGenerator = new LevelDescriptionGenerator();
        this.enemies = enemies;
    }

    public LevelBuilder getNumberOfEnemies(int count) {
        numberOfEnemies = count;
        return this;
    }

    public LevelBuilder getEnemies(int numberOfEnemies) {
        enemies = enemyFactory.createRandomEnemies(numberOfEnemies);
        return this;
    }

    public LevelBuilder getDescription() {
        startingDescription = levelDescriptionGenerator.generateDescription();
        return this;
    }

    public Level build() {
        return new LevelBuilder(items,startingDescription, numberOfEnemies, enemies);
    }
}