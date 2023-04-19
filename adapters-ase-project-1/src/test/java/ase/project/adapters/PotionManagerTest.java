package ase.project.adapters;

import ase.project.adapters.input.ScannerInputProvider;
import ase.project.application.item.potion.PotionType;
import ase.project.application.player.PlayerManager;
import ase.project.application.player.classes.Busker;
import ase.project.domain.action.InputProvider;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void iteratePotionTypes() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        PotionManager potionManager = new PotionManager(new ScannerInputProvider());
        String expectedOutput = "Choose a potion type: \n1: HEALTH\n2: MANA\n";

        potionManager.iteratePotionTypes();

        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }
}