package ase.project.adapters;

import ase.project.application.enemies.EnemyFactoryImpl;
import ase.project.application.enemies.bosses.SoldierOfGodrick;
import ase.project.application.levels.LevelBuilder;
import ase.project.application.levels.speciallevels.FinalLevel;
import ase.project.application.levels.speciallevels.FirstLevel;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.HashMap;
import java.util.Map;

public class LevelManager {

    private EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
    private Level level;

    public Level generateFirstLevel() {
        Map<Integer, Enemy> enemies = enemyFactory.createRandomEnemies(1);
        level = new FirstLevel(enemies, null); //ToDo remove starting Desrciption from contructot
        System.out.println(level.getStartingLevelDescription());
        //ToDo getDescription for each enemy -description loader plus name of the enemy
        return level;
    }

    public Level generateNextLevel() {
        Map<Integer, Enemy> enemies =  enemyFactory.createRandomEnemies(4);
        level = new LevelBuilder()
                .setEnemies(enemies)
                .setLevelDescription()
                .build();
        System.out.println(level.getStartingLevelDescription());
        // ToDo getDescription for each enemy -description loader plus name of the enemy
        return level;
    }

    public Level generateFinalLevel() {
        Map<Integer, Enemy> enemies = new HashMap<>();
        Enemy boss = new SoldierOfGodrick("Soldier of Godrick", 50, 50, 10);
        enemies.put(1, boss);

        level = new FinalLevel(enemies);

        System.out.println(level.getStartingLevelDescription());
        System.out.println(boss.getEnemyDescription());
        return level;
    }
}
