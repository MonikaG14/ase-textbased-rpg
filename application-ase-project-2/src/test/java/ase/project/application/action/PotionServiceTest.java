package ase.project.application.action;

import ase.project.application.item.potion.PotionType;
import ase.project.application.player.Astronomer;
import ase.project.application.player.PlayerClass;
import ase.project.domain.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PotionServiceTest {
    @Mock
    PlayerClass mockPlayer;

    @BeforeEach
    public void setMockPlayer() {
        mockPlayer = new Astronomer("AstroTest", 60, 60, 40, 3, 2, 10);
    }

    @Test
    void testUsePotion_Mana() {
        PotionType potionType = PotionType.MANA;

        Player result = mockPlayer.drink(potionType.toString(), mockPlayer);

        assertEquals(mockPlayer, result);
        assertEquals(1, result.getAmountManaPotions());
        assertEquals(50, result.getMana());
    }

    @Test
    void testUsePotions_Health() {
        PotionType potionType = PotionType.HEALTH;

        Player result = mockPlayer.drink(potionType.toString(), mockPlayer);

        assertEquals(mockPlayer, result);
        assertEquals(2, result.getAmountHealthPotions());
        assertEquals(80, result.getCurrentHealth());
    }
}