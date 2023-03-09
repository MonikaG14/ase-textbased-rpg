package ase.project.application.action.attacks;

import ase.project.application.exception.InvalidAttackException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;

import java.util.Map;

public class UseSpecialAttack {

    public static void useSpecialAttack(Character target, String attackName, int mana, Map<String, SpecialAttack> specialAttackList) {
        try {
            SpecialAttack specialAttack = specialAttackList.get(attackName);
            if (specialAttack != null) {
                specialAttack.useSpecialAttack(target, attackName, mana);
            } else {
                throw new InvalidAttackException("Invalid attack: " + attackName);
            }
        } catch (InvalidAttackException e) {
            System.out.println(e.getMessage());
        }
    }
}
