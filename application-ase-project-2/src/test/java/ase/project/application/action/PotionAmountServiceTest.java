package ase.project.application.action;

import ase.project.application.action.potion.PotionAmountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PotionAmountServiceTest {

    @Mock
    private PotionAmountService potionAmountService;

    @Test
    void testCheckAmountOfPotions() {
        assertThrows(NullPointerException.class, () -> potionAmountService.checkAmountOfPotions(null));
    }
}