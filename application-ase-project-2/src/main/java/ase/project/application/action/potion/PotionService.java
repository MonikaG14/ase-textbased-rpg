package ase.project.application.action.potion;

import ase.project.application.item.potion.PotionFactory;
import ase.project.application.item.potion.PotionType;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;

public class PotionService {
    private final PotionAmountService potionAmountService;
    private final PotionUsageService potionUsageService;

    public PotionService(PotionTypeService potionTypeService, PotionAmountService potionAmountService,
                         PotionUsageService potionUsageService) {
        this.potionAmountService = potionAmountService;
        this.potionUsageService = potionUsageService;
    }

    public Player usePotion(String potionType, PlayerManager player) {
        if (potionType == null || potionType.isEmpty()) {
            throw new IllegalArgumentException("Potion type cannot be null or empty");
        }
        PotionType type = PotionType.valueOf(potionType.toUpperCase());
        Potion potion = PotionFactory.getPotion(type);

        potionAmountService.checkAmountOfPotions(player.getAmountOfPotionType().get(type));
        player.updateAmountOfPotionType(type, player);

        return potionUsageService.usePotion(potion, player);
    }
}
