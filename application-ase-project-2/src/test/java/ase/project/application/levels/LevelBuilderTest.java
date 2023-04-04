package ase.project.application.levels;

import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.domain.characters.Enemy;
import ase.project.domain.item.Item;
import ase.project.domain.level.Level;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelBuilderTest {

    @Test
    public void testRemoveDeadEnemy() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new PhyrexianMite("Enemy 1", 10, 40, 10));
        enemies.add(new PhyrexianMite("Enemy 2", 0, 40, 10));
        Level level = new FirstLevel(enemies, null, "Starting Level Description");

        level.removeDeadEnemy(enemies.get(1));

        assertEquals(1, level.getEnemies().size());
        assertEquals("Enemy 1", level.getEnemies().get(0).getName());
    }

}