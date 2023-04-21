package ase.project.domain.characters.enemy;

import java.util.Map;

public interface EnemyFactory {

    Map<Integer, Enemy> createRandomEnemies(int count);
}
