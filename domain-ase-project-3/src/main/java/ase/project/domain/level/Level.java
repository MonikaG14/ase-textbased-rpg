package ase.project.domain.level;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.characters.enemy.EnemyFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level {

    protected Map<Integer, Enemy> enemies;
    protected String startingLevelDescription;
    protected EnemyFactory enemyFactory;


    public Level(Map<Integer, Enemy> enemies) {
        this.enemies = enemies;
    }

    public Level(Map<Integer, Enemy> enemies, String startingLevelDescription) {
        this.enemies = enemies;
        this.startingLevelDescription = startingLevelDescription;
    }

    public Map<Integer, Enemy> createEnemies(int numberOfEnemies) {
        enemies = enemyFactory.createRandomEnemies(numberOfEnemies);
        return enemies;
    }

    public Map<Integer, Enemy> getEnemies() {
        return enemies;
    }


    public void removeDeadEnemy(Character enemy) {
        for (Map.Entry<Integer, Enemy> entry : enemies.entrySet()) {
            if (entry.getValue().equals(enemy)) {
                enemies.remove(entry.getKey());
                break;
            }
        }
    }

    public String getStartingLevelDescription() {
        return startingLevelDescription;
    }

    public boolean isFinalLevel() {
        return false;
    }
}
