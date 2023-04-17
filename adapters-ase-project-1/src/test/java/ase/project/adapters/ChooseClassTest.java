package ase.project.adapters;

import ase.project.adapters.player.ChooseClass;
import ase.project.application.player.classes.Astronomer;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChooseClassTest {

    private ChooseClass chooseClass;

    @BeforeEach
    void setUp() {
        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.readInt()).thenReturn(1);
        chooseClass = new ChooseClass(inputProvider);
    }
    @Test
    void testChooseClass() {
        Player player = chooseClass.chooseClass();
        assertTrue(player instanceof Astronomer);
    }
}