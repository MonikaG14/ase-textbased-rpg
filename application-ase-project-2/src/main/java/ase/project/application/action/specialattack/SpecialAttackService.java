package ase.project.application.action.specialattack;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpecialAttackService {
    public SpecialAttack chooseSpecialAttack(Map<String, SpecialAttack> specialAttackList, String attackName) throws InvalidAttackException {
        SpecialAttack specialAttack = specialAttackList.get(attackName);
        try {
            if (specialAttack == null) {
                throw new InvalidAttackException("Invalid attack name: " + attackName);
            }
        } catch (NullPointerException e) {
            throw new InvalidAttackException("Invalid attack name: " + attackName);
        }
        return specialAttack;
    }

    public SpecialAttack chooseRandomSpecialAttack(Map<Integer, SpecialAttack> specialAttackList) throws InvalidAttackException {
        Random random = new Random();
        List<Integer> keyList = new ArrayList<>(specialAttackList.keySet());
        int index = random.nextInt(specialAttackList.size());
        Integer key = keyList.get(index);
        SpecialAttack specialAttack = specialAttackList.get(key);
        try {
            if (specialAttack == null) {
                throw new InvalidAttackException("Invalid attack");
            }
        } catch (NullPointerException e) {
            throw new InvalidAttackException("Invalid attack");
        }
        return specialAttack;
    }
}
