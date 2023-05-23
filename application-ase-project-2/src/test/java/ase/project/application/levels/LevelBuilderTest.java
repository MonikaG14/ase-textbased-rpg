package ase.project.application.levels;

import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.levels.speciallevels.FirstLevel;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LevelBuilderTest {

    @Test
    public void testRemoveDeadEnemy() {
        Map<Integer, Enemy> enemies = new HashMap<>();
        enemies.put(1, new PhyrexianMite("Phyrexian Mite", 10, 40, 10));
        enemies.put(2, new PhyrexianMite("Phyrexian Mite", 0, 40, 10));
        Level level = new FirstLevel(enemies, null);

        level.removeDeadEnemy(enemies.get(1));

        assertEquals(2, level.getEnemies().size());
        assertEquals("Phyrexian Mite", level.getEnemies().get(1).getName());
    }
}