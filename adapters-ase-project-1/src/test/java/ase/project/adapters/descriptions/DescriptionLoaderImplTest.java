package ase.project.adapters.descriptions;

import ase.project.domain.action.DescriptionLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionLoaderImplTest {

    @Test
    void getDescription() {
        DescriptionLoader loader = new DescriptionLoaderImpl();
        String expectedHealthPotion = "Fiery Ingwer Shot - blood rushing to your face, watery eyes, flaming mouth and nostrils are common side effects of chugging Ingwer shots uncontrollably";
        String expectedFireballBarrage = "Fireball Barrage - Summon a rain of fireballs from the sky, because why not make it rain fire?";
        String expectedSpinToWin = "Spin To Win - Turn you panic-stricken daze into a deadly weapon";

        assertEquals(expectedHealthPotion, loader.getDescription("health_potion"));
        assertEquals(expectedFireballBarrage, loader.getDescription("fireball_barrage"));
        assertEquals(expectedSpinToWin, loader.getDescription("spin_to_win"));
        assertNull(loader.getDescription("invalid_key"));
    }

}