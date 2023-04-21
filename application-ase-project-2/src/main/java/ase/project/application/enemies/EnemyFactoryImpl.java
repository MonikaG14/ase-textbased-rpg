package ase.project.application.enemies;

import ase.project.application.enemies.mobs.AbyssWatcher;
import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.characters.enemy.EnemyFactory;

import java.lang.reflect.Constructor;
import java.util.*;

public class EnemyFactoryImpl implements EnemyFactory {
    private static final List<Class<? extends Enemy>> ENEMY_CLASSES = Arrays.asList(
            PhyrexianMite.class,
            AbyssWatcher.class
    );

    public Map<Integer, Enemy> createRandomEnemies(int count) {
        Map<Integer, Enemy> enemies = new HashMap<>();
        Random random = new Random();
        for (int i = 1; i < count + 1; i++) {
            Class<? extends Enemy> enemyClass = ENEMY_CLASSES.get(random.nextInt(ENEMY_CLASSES.size()));
            try {
                Constructor<? extends Enemy> constructor = enemyClass.getConstructor(String.class, int.class, int.class, int.class);
                String enemyName = enemyClass.getName();
                Enemy enemy = constructor.newInstance(enemyName + i, 10, 10, 10);
                enemies.put(i, enemy);
            } catch (Exception exception) {
                throw new RuntimeException("Failed to create enemy " + exception);
            }
        }
        return enemies;
    }
}
