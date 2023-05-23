package ase.project.application.levels.speciallevels;

import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.item.Item;
import ase.project.domain.level.Level;

import java.util.List;
import java.util.Map;

public class FirstLevel extends Level {

    public FirstLevel(Map<Integer, Enemy> enemies, List<Item> items) {
        super(enemies);
    }

    @Override
    public String getStartingLevelDescription() {
        return "Description for level 1"; //ToDO
    }
}
