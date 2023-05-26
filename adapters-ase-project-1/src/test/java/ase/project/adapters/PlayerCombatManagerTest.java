package ase.project.adapters;

import ase.project.adapters.player.PlayerCombatManager;
import ase.project.application.enemies.EnemyFactoryImpl;
import ase.project.application.enemies.mobs.AbyssWatcher;
import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.player.PlayerManager;
import ase.project.application.player.classes.Astronomer;
import ase.project.domain.action.InputProvider;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerCombatManagerTest {

    private final EnemyFactoryImpl enemyFactoryImpl = new EnemyFactoryImpl();
    private final Map<Integer, Enemy> enemyMap = enemyFactoryImpl.createRandomEnemies(3);
    private final Astronomer astronomer = new Astronomer("Test", 10, 40, 20, 2, 2, 10);
    private final Level level = new Level(enemyMap, null);
    @Mock
    private InputProvider inputProvider;


    @Test
    void testChooseSpecialAttack() {
        PlayerManager player = mock(PlayerManager.class);
        SpecialAttack attack1 = mock(SpecialAttack.class);
        SpecialAttack attack2 = mock(SpecialAttack.class);

        when(attack1.getName()).thenReturn("Special Attack 1");
        when(attack2.getName()).thenReturn("Special Attack 2");

        Map<String, SpecialAttack> specialAttacks = new HashMap<>();
        specialAttacks.put("Special Attack 1", attack1);
        specialAttacks.put("Special Attack 2", attack2);
        when(player.getSpecialAttackList()).thenReturn(specialAttacks);

        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.readInt()).thenReturn(2);
        PlayerCombatManager playerCombatManager = new PlayerCombatManager(inputProvider);


        String result = playerCombatManager.chooseSpecialAttack(player);
        assertEquals("Special Attack 2", result);
    }

    @Test
    void testChooseTarget() {
        Level level = mock(Level.class);
        Map<Integer, Enemy> enemyMap = new HashMap<>();
        enemyMap.put(1, new PhyrexianMite("Phyrexian Mite", 10, 10, 10));
        enemyMap.put(2, new AbyssWatcher("Abyss Watcher", 10, 10, 10));

        when(level.getEnemies()).thenReturn(enemyMap);

        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.readInt()).thenReturn(2);
        PlayerCombatManager playerCombatManager = new PlayerCombatManager(inputProvider);


        Enemy chosenEnemy = playerCombatManager.chooseTarget(level);
        assertEquals("Abyss Watcher", chosenEnemy.getName());
    }

    @Test
    void testIterateSpecialAttacks() {
        PlayerCombatManager playerCombatManager = new PlayerCombatManager(inputProvider);

        Map<Integer, SpecialAttack> attackMap = playerCombatManager.iterateSpecialAttacks(astronomer);

        assertEquals(2, attackMap.size());
        assertEquals("Fireball Barrage", attackMap.get(1).getName());
        assertEquals("Flame Tsunami", attackMap.get(2).getName());
    }

    @Test
    void testIterateEnemies() {
        PlayerCombatManager playerCombatManager = new PlayerCombatManager(inputProvider);

        Map<Integer, Enemy> enemyMap = playerCombatManager.iterateEnemies(level);

        assertEquals(3, enemyMap.size());
    }
}
