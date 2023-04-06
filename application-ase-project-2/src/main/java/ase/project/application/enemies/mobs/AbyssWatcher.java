package ase.project.application.enemies.mobs;

import ase.project.application.enemies.EnemyManager;
import ase.project.domain.characters.Character;
import ase.project.domain.dice.DiceRoller;

public class AbyssWatcher extends EnemyManager {

    public AbyssWatcher(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth, power);
    }

    @Override
    public void useBasicAttack(Character target) {
        int damage = DiceRoller.rollDice(6) + this.power;
        target.takeDamage(damage);
        System.out.println("You were hit by Abyss Watcher for " + damage + " damage!");
    }

    @Override
    public String getEnemyDescription() {
        return "The Abyss Watchers, the legendary warriors of Farron's Undead Legion, are the stuff of nightmares. \nThey are the ultimate bros, always ready to party, but once they put on their fancy red cloaks and unsheathe their fiery swords, \nthey transform into a fearsome pack of frat boys on a rampage. \nThey fight with the precision of synchronized swimmers, and their coordination is so tight, you'll think you're watching a dance routine. \nAnd when they start summoning their spectral buddies to the dance floor, you'll know it's time to get serious.";
    }
}
