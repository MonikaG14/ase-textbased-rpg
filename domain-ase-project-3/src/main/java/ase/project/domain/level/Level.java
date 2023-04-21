package ase.project.domain.level;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.characters.enemy.EnemyFactory;
import ase.project.domain.item.Item;

import java.util.List;
import java.util.Map;

public abstract class Level {

    protected Map<Integer, Enemy> enemies;
    protected List<Item> items;
    protected String startingLevelDescription;
    protected String endingLevelDescription;

    protected EnemyFactory enemyFactory;

    public Level(Map<Integer, Enemy> enemies, List<Item> items, String startingLevelDescription) {
        this.enemies = enemies;
        this.items = items;
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
        enemies.remove(enemy);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getStartingLevelDescription() {
        return startingLevelDescription;
    }
}
