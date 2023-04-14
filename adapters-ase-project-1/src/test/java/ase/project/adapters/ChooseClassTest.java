package ase.project.adapters;

import ase.project.application.player.classes.Astronomer;
import ase.project.domain.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChooseClassTest {

    private ChooseClass chooseClass;

    @BeforeEach
    void setUp() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextInt()).thenReturn(1);
        chooseClass = new ChooseClass(scanner);
    }
    @Test
    void testAddition() {
        Player player = chooseClass.chooseClass();
        assertTrue(player instanceof Astronomer);
    }
}