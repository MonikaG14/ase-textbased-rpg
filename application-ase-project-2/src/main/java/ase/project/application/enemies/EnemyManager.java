package ase.project.application.enemies;

import ase.project.application.action.specialattack.SpecialAttackService;
import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.dice.DiceRoller;

import java.util.HashMap;
import java.util.Map;

public abstract class EnemyManager extends Enemy {

    protected String keyToDescription;
    protected Map<Integer, SpecialAttack> specialAttackList;
    protected SpecialAttackService specialAttackService;

    public EnemyManager(String name, int currentHealth, int maxHealth, int power) {
        super(name, currentHealth, maxHealth, power);
        specialAttackService = new SpecialAttackService();
        specialAttackList = new HashMap<>();
    }

    public Character useSpecialAttack(Character target) throws InvalidAttackException {
        SpecialAttack specialAttack = specialAttackService.chooseRandomSpecialAttack(this.getSpecialAttackList());
        specialAttack.performSpecialAttack(target);
        return target;
    }

    public void chooseBetweenSpecialAndBasicAttack(Character target) throws InvalidAttackException {
        int number = DiceRoller.rollDice(10);
        if (number < 4) {
            useSpecialAttack(target);
        } else {
            useBasicAttack(target);
        }
    }

    public Map<Integer, SpecialAttack> getSpecialAttackList() {
        return specialAttackList;
    }

    public String getKeyToDescription() {
        return keyToDescription;
    }
}
