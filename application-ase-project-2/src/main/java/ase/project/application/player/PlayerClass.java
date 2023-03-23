package ase.project.application.player;

import ase.project.application.action.ManaService;
import ase.project.application.action.attacks.ChooseSpecialAttack;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.exception.InvalidManaException;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerClass extends Player {
    protected Map<String, SpecialAttack> specialAttackList;
    protected Map<PotionType, Integer> potionTypeAmount;

    public PlayerClass(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.specialAttackList = new HashMap<>();
        this.potionTypeAmount = new HashMap<>();
        this.potionTypeAmount.put(PotionType.HEALTH, amountHealthPotions);
        this.potionTypeAmount.put(PotionType.MANA, amountManaPotions);
    }

    public void useSpecialAttack(Character target, String attackName) throws InvalidAttackException {
        SpecialAttack specialAttack = ChooseSpecialAttack.chooseSpecialAttack(specialAttackList, attackName);
        try {
            ManaService.checkMana(mana, specialAttack.getManaCost());
            specialAttack.performSpecialAttack(target, attackName);
            mana = ManaService.useMana(mana, specialAttack.getManaCost());
        } catch (InvalidManaException manaException) {
            System.out.println(manaException.getMessage());
        }
    }

    public Map<String, SpecialAttack> getSpecialAttackList() {
        return this.specialAttackList;
    }

    public Map<PotionType, Integer> getPotionTypeAmount() {
        return potionTypeAmount;
    }
}
