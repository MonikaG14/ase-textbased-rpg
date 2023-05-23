package ase.project.application.levels;

import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.Map;

public class LevelBuilder {
    private Map<Integer, Enemy> enemies;
    private String startingLevelDescription;
    private final LevelDescriptionGenerator levelDescriptionGenerator = new LevelDescriptionGenerator();

    public LevelBuilder() {
    }

    public LevelBuilder setEnemies(Map<Integer, Enemy> enemies) {
        this.enemies = enemies;
        return this;
    }

    public LevelBuilder setLevelDescription() {
        startingLevelDescription = levelDescriptionGenerator.generateDescription();
        return this;
    }

    public Level build() {
        return new Level(enemies, startingLevelDescription);
    }
}