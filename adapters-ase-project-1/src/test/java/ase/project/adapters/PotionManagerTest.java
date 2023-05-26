package ase.project.adapters;

import ase.project.adapters.potion.PotionManager;
import ase.project.application.item.potion.PotionType;
import ase.project.application.player.PlayerManager;
import ase.project.application.player.classes.Busker;
import ase.project.domain.action.InputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PotionManagerTest {

    PlayerManager player = new Busker("Busker", 10, 10, 2, 1, 1, 15);

    @Test
    void testChoosePotionType() {
        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.readInt()).thenReturn(1);

        PotionManager potionManager = new PotionManager(inputProvider);

        potionManager.choosePotionType(player);
        assertEquals(1, player.getAmountOfPotionType().get(PotionType.MANA));
    }
}