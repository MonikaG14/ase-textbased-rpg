package ase.project.application.item.potion;

import ase.project.application.player.Astronomer;
import ase.project.application.player.PlayerManager;
import ase.project.domain.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ManaPotionTest {

    @Mock
    PlayerManager mockPlayer;

    @BeforeEach
    public void setMockPlayer() {
        mockPlayer = new Astronomer("Test", 60, 60, 30, 3, 2, 10);
    }

    @Test
    void drink() {
        ManaPotion manaPotion = new ManaPotion();

        Player result = manaPotion.drink(mockPlayer);

        assertEquals(mockPlayer, result);
        assertEquals(1, result.getAmountManaPotions());
        assertEquals(40, result.getMana());
    }

}