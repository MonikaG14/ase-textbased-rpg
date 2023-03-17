package ase.project.application.player;

import ase.project.domain.characters.Enemy;
import ase.project.domain.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AstronomerTest {
    private Astronomer player;

    @Mock
    Enemy target;

    @BeforeEach
    public void setUp() {
        player = new Astronomer("AstroTest", 3, 3, 60, 60, 40, 10);
    }

    @Test
    void useBasicAttack() {
        final int diceRoll = 4;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(6)).thenReturn(diceRoll);

            int expectedDamage = diceRoll + player.getIntelligence();

            player.useBasicAttack(target);

            verify(target).takeDamage(expectedDamage);
        }
    }

    @Test
    void useSpecialAttack() {
    }
}