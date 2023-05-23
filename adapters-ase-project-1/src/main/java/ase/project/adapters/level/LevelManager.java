package ase.project.adapters.level;

import ase.project.adapters.descriptions.DescriptionManager;
import ase.project.application.enemies.EnemyFactoryImpl;
import ase.project.application.enemies.bosses.SoldierOfGodrick;
import ase.project.application.levels.LevelBuilder;
import ase.project.application.levels.speciallevels.FinalLevel;
import ase.project.application.levels.speciallevels.FirstLevel;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.HashMap;
import java.util.Map;

public class LevelManager {

    private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
    private final DescriptionManager descriptionManager;
    private Level level;

    public LevelManager(DescriptionManager descriptionManager) {
        this.descriptionManager = descriptionManager;
    }

    public Level generateFirstLevel(PlayerManager player) {
        Map<Integer, Enemy> enemies = enemyFactory.createRandomEnemies(1);
        level = new FirstLevel(enemies, null);

        descriptionManager.printFirstLevelDescription();
        descriptionManager.printUniqueEnemyDescriptions(enemies);
        descriptionManager.printPlayerWeaponDescription(player.getClass().getSimpleName());

        return level;
    }

    public Level generateNextLevel() {
        Map<Integer, Enemy> enemies =  enemyFactory.createRandomEnemies(4);
        level = new LevelBuilder()
                .setEnemies(enemies)
                .setLevelDescription()
                .build();

        descriptionManager.printLevelDescription(level);
        descriptionManager.printUniqueEnemyDescriptions(enemies);

        return level;
    }

    public Level generateFinalLevel() {
        Map<Integer, Enemy> enemies = new HashMap<>();
        Enemy boss = new SoldierOfGodrick("Soldier of Godrick", 50, 50, 10);
        enemies.put(1, boss);

        level = new FinalLevel(enemies);

        descriptionManager.printFinalLevelDescription();

        return level;
    }
}
