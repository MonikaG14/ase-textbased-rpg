package ase.project.application.action.attacks;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;

import java.util.Map;

public class ChooseSpecialAttack {

    public static SpecialAttack chooseSpecialAttack(Map<String, SpecialAttack> specialAttackList, String attackName) {
        SpecialAttack specialAttack = specialAttackList.get(attackName);
        try {
            if (specialAttack == null) {
                throw new InvalidAttackException("Invalid attack: " + attackName);
            }
        } catch (InvalidAttackException e) {
            System.out.println(e.getMessage());
        }
        return specialAttack;
    }
}
