package ase.project.adapters;

import ase.project.adapters.player.PlayerClassManager;
import ase.project.application.player.classes.Astronomer;
import ase.project.domain.action.InputProvider;
import ase.project.domain.characters.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerClassManagerTest {

    private PlayerClassManager playerClassManager;

    @BeforeEach
    void setUp() {
        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.readInt()).thenReturn(1);
        playerClassManager = new PlayerClassManager(inputProvider);
    }
    @Test
    void testChooseClass() {
        Player player = playerClassManager.chooseClass();
        assertTrue(player instanceof Astronomer);
    }
}