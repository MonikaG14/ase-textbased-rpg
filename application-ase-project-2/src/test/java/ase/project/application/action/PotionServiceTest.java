package ase.project.application.action;

import ase.project.application.item.potion.HealthPotion;
import ase.project.application.item.potion.ManaPotion;
import ase.project.application.item.potion.PotionType;
import ase.project.application.player.Astronomer;
import ase.project.application.player.PlayerClass;
import ase.project.domain.item.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PotionServiceTest {

    @Mock
    PlayerClass mockPlayer;

    @BeforeEach
    public void setMockPlayer() {
        mockPlayer = new Astronomer("AstroTest", 60, 60, 40, 3, 2, 10);
    }

    @Test
    void testChoosePotionType() {
        Potion potion = PotionService.choosePotionType(PotionType.HEALTH);

        assertTrue(potion instanceof HealthPotion);
    }

    @Test
    void testCheckAmountOfPotions() {
        assertThrows(IllegalArgumentException.class, () -> {
            PotionService.checkAmountOfPotions(null);
        });
    }

    @Test
    void testHealthStringToPotionType() {
        String typeString = "HEALTH";
        PotionType type = PotionType.valueOf(typeString.toUpperCase());
        Potion expectedPotion = PotionService.choosePotionType(type);

        Potion actualPotion = new HealthPotion();

        assertEquals(expectedPotion.getClass(), actualPotion.getClass());
    }

    @Test
    void testManaStringToPotionType() {
        String typeString = "mana";
        PotionType type = PotionType.valueOf(typeString.toUpperCase());
        Potion expectedPotion = PotionService.choosePotionType(type);

        Potion actualPotion = new ManaPotion();

        assertEquals(expectedPotion.getClass(), actualPotion.getClass());
    }
}