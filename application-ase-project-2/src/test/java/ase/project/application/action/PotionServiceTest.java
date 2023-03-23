package ase.project.application.action;

import ase.project.application.item.potion.HealthPotion;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.item.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionServiceTest {

    @Test
    void testChoosePotionType() {
        Potion potion = PotionService.choosePotionType(PotionType.HEALTH);
        assertTrue(potion instanceof HealthPotion);
    }

    @Test
    void checkAmountOfPotions() {
        assertThrows(IllegalArgumentException.class, () -> {
            PotionService.checkAmountOfPotions(null);
        });
    }
}