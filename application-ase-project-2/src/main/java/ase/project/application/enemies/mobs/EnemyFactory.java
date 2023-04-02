package ase.project.application.enemies.mobs;

import ase.project.domain.characters.Enemy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EnemyFactory {
    private static final List<Class<? extends Enemy>> ENEMY_CLASSES = Arrays.asList(
            PhyrexianMite.class
    );

    public List<Enemy> createRandomEnemies(int count) {
        List<Enemy> enemies = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Class<? extends Enemy> enemyClass = ENEMY_CLASSES.get(random.nextInt(ENEMY_CLASSES.size()));
            try {
                Constructor<? extends Enemy> constructor = enemyClass.getConstructor(UUID.class);
                Enemy enemy = constructor.newInstance(UUID.randomUUID());
                enemies.add(enemy);
            } catch (Exception exception) {
                throw new RuntimeException("Failed to create enemy" + exception);
            }
        }
        return enemies;
    }
}
