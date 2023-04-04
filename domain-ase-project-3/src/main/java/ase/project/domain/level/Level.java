package ase.project.domain.level;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.Enemy;
import ase.project.domain.item.Item;

import java.util.List;

public abstract class Level {
    protected List<Enemy> enemies;
    protected List<Item> items;
    protected String startingLevelDescription;
    protected String endingLevelDescription;

    public Level(List<Enemy> enemies, List<Item> items, String startingLevelDescription) {
        this.enemies = enemies;
        this.items = items;
        this.startingLevelDescription = startingLevelDescription;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void checkIfDead(Character character) {
        if (character.getCurrentHealth() <= 0) {
            removeDeadEnemy(character);
        }
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
