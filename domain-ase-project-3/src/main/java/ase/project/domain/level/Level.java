package ase.project.domain.level;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;

import java.util.Map;

public class Level {

    protected Map<Integer, Enemy> enemies;
    protected String startingLevelDescription;


    public Level(Map<Integer, Enemy> enemies) {
        this.enemies = enemies;
    }

    public Level(Map<Integer, Enemy> enemies, String startingLevelDescription) {
        this.enemies = enemies;
        this.startingLevelDescription = startingLevelDescription;
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

}
