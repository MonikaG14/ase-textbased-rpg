package ase.project.domain.level;

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
}
