package ase.project.application.action.attacks;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;

import java.util.Map;

public class ChooseSpecialAttack {
    public static SpecialAttack chooseSpecialAttack(Map<String, SpecialAttack> specialAttackList, String attackName) throws InvalidAttackException {
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
}
