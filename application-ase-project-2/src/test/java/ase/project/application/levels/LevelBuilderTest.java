package ase.project.application.levels;

import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.levels.speciallevels.FirstLevel;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelBuilderTest {

    @Test
    public void testRemoveDeadEnemy() {
        Map<Integer, Enemy> enemies = new HashMap<>();
        Enemy enemy1 = new PhyrexianMite("Phyrexian Mite", 10, 40, 10);
        Enemy enemy2 = new PhyrexianMite("Phyrexian Mite", 0, 40, 10);
        enemies.put(1, enemy1);
        enemies.put(2, enemy2);
        Level level = new FirstLevel(enemies, null);

        level.removeDeadEnemy(enemy1);

        assertEquals(1, level.getEnemies().size());
        assertEquals(enemy2, level.getEnemies().get(2));
    }
}