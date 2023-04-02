package ase.project.application.player;

import ase.project.application.action.*;
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
    protected Map<PotionType, Integer> amountOfPotionType;
    protected final PotionService potionService;
    protected final SpecialAttackService specialAttackService;

    public PlayerClass(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.specialAttackList = new HashMap<>();
        this.amountOfPotionType = new HashMap<>();
        amountOfPotionType.put(PotionType.HEALTH, amountHealthPotions);
        amountOfPotionType.put(PotionType.MANA, amountManaPotions);
        this.potionService = new PotionService(new PotionTypeService(), new PotionAmountService(), new PotionUsageService());
        specialAttackService = new SpecialAttackService();
    }

    public void useSpecialAttack(Character target, String attackName) throws InvalidAttackException {
        SpecialAttack specialAttack = specialAttackService.chooseSpecialAttack(specialAttackList, attackName);
        try {
            ManaService.checkMana(mana, specialAttack.getManaCost());
            specialAttack.performSpecialAttack(target);
            mana = ManaService.useMana(mana, specialAttack.getManaCost());
        } catch (InvalidManaException manaException) {
            System.out.println(manaException.getMessage());
        }
    }

    public Player updateAmountOfPotionType(PotionType potionType, PlayerClass player) {
        this.amountOfPotionType.put(potionType, player.amountOfPotionType.get(potionType) - 1);
        return this;
    }

    public Player drink(String potionType, PlayerClass player) {
        return potionService.usePotion(potionType, player);
    }

    public void setPotionMaps() {
        amountOfPotionType.put(PotionType.HEALTH, amountHealthPotions);
        amountOfPotionType.put(PotionType.MANA, amountManaPotions);
    }

    public Map<String, SpecialAttack> getSpecialAttackList() {
        return this.specialAttackList;
    }

    public Map<PotionType, Integer> getAmountOfPotionType() {
        return amountOfPotionType;
    }
}
