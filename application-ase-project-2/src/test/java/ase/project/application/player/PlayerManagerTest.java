package ase.project.application.player;

import ase.project.application.item.potion.PotionType;
import ase.project.application.player.classes.Astronomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PlayerManagerTest {

    @Mock
    private PlayerManager player;

    @BeforeEach
    public void setUp() {
        player = new Astronomer("AstroTest", 60, 60, 40, 3, 2, 10);
    }

    @Test
    void updateAmountOfPotionType() {
        player.setPotionMaps();

        player.updateAmountOfPotionType(PotionType.HEALTH, player);

       assertEquals(2, player.amountOfPotionType.get(PotionType.HEALTH));
    }
}