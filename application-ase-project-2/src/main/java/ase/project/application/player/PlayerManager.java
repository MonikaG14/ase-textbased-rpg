package ase.project.application.player;

import ase.project.application.action.*;
import ase.project.application.action.potion.PotionAmountService;
import ase.project.application.action.potion.PotionService;
import ase.project.application.action.potion.PotionTypeService;
import ase.project.application.action.potion.PotionUsageService;
import ase.project.application.action.specialattack.SpecialAttackService;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Character;
import ase.project.domain.characters.player.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerManager extends Player {
    protected Map<String, SpecialAttack> specialAttackList;
    protected Map<PotionType, Integer> amountOfPotionType;
    protected final PotionService potionService;
    protected final SpecialAttackService specialAttackService;

    public PlayerManager(String name, int currentHealth, int maxHealth, int mana, int amountHealthPotions, int amountManaPotions) {
        super(name, currentHealth, maxHealth, mana, amountHealthPotions, amountManaPotions);
        this.specialAttackList = new HashMap<>();
        this.amountOfPotionType = new HashMap<>();
        amountOfPotionType.put(PotionType.HEALTH, amountHealthPotions);
        amountOfPotionType.put(PotionType.MANA, amountManaPotions);
        this.potionService = new PotionService(new PotionTypeService(), new PotionAmountService(), new PotionUsageService());
        specialAttackService = new SpecialAttackService();
    }

    public void useSpecialAttack(Character target, String attackName) throws InvalidAttackException, InsufficientManaException {
        SpecialAttack specialAttack = specialAttackService.chooseSpecialAttack(specialAttackList, attackName);
        try {
            ManaService.checkMana(mana, specialAttack.getManaCost());
            specialAttack.performSpecialAttack(target);
            mana = ManaService.useMana(mana, specialAttack.getManaCost());
        } catch (InsufficientManaException e) {
            System.out.println("You do not have enough mana for this attack!");
        }
    }

    public void updateAmountOfPotionType(PotionType potionType, PlayerManager player) {
        this.amountOfPotionType.put(potionType, player.amountOfPotionType.get(potionType) - 1);
    }

    public Player drink(String potionType, PlayerManager player) {
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
