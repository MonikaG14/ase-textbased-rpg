package ase.project.domain.characters;

import java.util.List;

public abstract class Enemy extends Character {
    protected int power;
    protected List<Enemy> enemyList;
    protected String enemyDescription;

    public Enemy(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth);
        this.power = power;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    @Override
    public void dies(Character deadEnemy) {
        List<Enemy> enemyList = this.getEnemyList();
        enemyList.remove(deadEnemy);
        deadEnemy = null;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }
}
