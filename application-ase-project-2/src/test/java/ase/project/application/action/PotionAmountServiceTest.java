package ase.project.application.action;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PotionAmountServiceTest {

    @Mock
    PotionAmountService potionAmountService;
    @Test
    void testCheckAmountOfPotions() {
        assertThrows(IllegalArgumentException.class, () -> {
            potionAmountService.checkAmountOfPotions(null);
        });
    }
}