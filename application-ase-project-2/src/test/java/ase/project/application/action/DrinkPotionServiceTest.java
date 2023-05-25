package ase.project.application.action;

import ase.project.application.action.potion.DrinkPotionService;
import ase.project.domain.characters.player.Player;
import ase.project.domain.item.Potion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DrinkPotionServiceTest {

    @Test
    void testUsePotion() {
        Potion potion = mock(Potion.class);
        Player player = mock(Player.class);

        Mockito.when(potion.drink(player)).thenReturn(player);

        DrinkPotionService drinkPotionService = new DrinkPotionService();

        assertEquals(player, drinkPotionService.drinkPotion(potion, player));
    }
}