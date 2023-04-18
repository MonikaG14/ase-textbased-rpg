package ase.project.application.action;

import ase.project.application.action.potion.PotionTypeService;
import ase.project.application.item.potion.HealthPotion;
import ase.project.application.item.potion.ManaPotion;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.item.Potion;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PotionTypeServiceTest {
    @Mock
    private PotionTypeService potionTypeService = new PotionTypeService();

    @Test
    void testChoosePotionType() {
        Potion potion = potionTypeService.choosePotionType(PotionType.HEALTH);

        assertTrue(potion instanceof HealthPotion);
    }

    @Test
    void testHealthStringToPotionType() {
        String typeString = "HEALTH";
        PotionType type = PotionType.valueOf(typeString.toUpperCase());
        Potion expectedPotion = potionTypeService.choosePotionType(type);

        Potion actualPotion = new HealthPotion();

        assertEquals(expectedPotion.getClass(), actualPotion.getClass());
    }

    @Test
    void testManaStringToPotionType() {
        String typeString = "mana";
        PotionType type = PotionType.valueOf(typeString.toUpperCase());
        Potion expectedPotion = potionTypeService.choosePotionType(type);

        Potion actualPotion = new ManaPotion();

        assertEquals(expectedPotion.getClass(), actualPotion.getClass());
    }
}