package ase.project.application.levels.speciallevels;

import ase.project.application.enemies.bosses.SoldierOfGodrick;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.level.Level;

import java.util.Map;

public class FinalLevel extends Level {

    private String endDescription;

    public FinalLevel(Map<Integer, Enemy> enemies) {
        super(enemies);
    }

    public Map<Integer, Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public String getStartingLevelDescription() {
        return "Description for the final level"; //ToDO
    }

    public String getEndDescription() {
        return "end descrp level"; //ToDo EndDescription
    }

    @Override
    public boolean isFinalLevel() {
        return true;
    }
}
