package ase.project.application.action;

import ase.project.application.action.potion.PotionUsageService;
import ase.project.domain.characters.Player;
import ase.project.domain.item.Potion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PotionUsageServiceTest {

    @Test
    void usePotion() {
        Potion potion = mock(Potion.class);
        Player player = mock(Player.class);

        Mockito.when(potion.drink(player)).thenReturn(player);

        PotionUsageService potionUsageService = new PotionUsageService();

        assertEquals(player, potionUsageService.usePotion(potion, player));
    }
}