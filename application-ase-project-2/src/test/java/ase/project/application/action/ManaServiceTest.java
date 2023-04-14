package ase.project.application.action;

import ase.project.application.exception.InsufficientManaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManaServiceTest {

    @Test
    void checkManaWithEnoughMana() {
        int mana = 10;
        int manaCost = 5;

        assertDoesNotThrow(() -> ManaService.checkMana(mana, manaCost));
    }

    @Test
    void checkManaWithoutEnoughMana() {
        int mana = 5;
        int manaCost = 10;

        assertThrows(InsufficientManaException.class, () -> ManaService.checkMana(mana, manaCost));
    }

    @Test
    void useMana() {
        int mana = 10;
        int manaCost = 5;
        int expectedMana = 5;
        int actualMana = ManaService.useMana(mana, manaCost);

        assertEquals(expectedMana, actualMana);
    }
}