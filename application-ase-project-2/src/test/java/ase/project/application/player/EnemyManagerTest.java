package ase.project.application.player;

import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.classes.Astronomer;
import ase.project.domain.dice.DiceRoller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnemyManagerTest {
    @Mock
    private Astronomer mockPlayer;

    @Test
    void chooseBetweenSpecialAndBasicAttack_BasicAttack() throws InvalidAttackException {
        int number = 4;
        try(MockedStatic<DiceRoller> diceRollerMockedStatic = Mockito.mockStatic(DiceRoller.class)) {
            diceRollerMockedStatic.when(() -> DiceRoller.rollDice(10)).thenReturn(number);

            PhyrexianMite spyMite = Mockito.spy(new PhyrexianMite("test", 10, 10, 5));

            spyMite.chooseBetweenSpecialAndBasicAttack(mockPlayer);

            Mockito.verify(spyMite).useBasicAttack(mockPlayer);
        }
    }

    @Test
    void chooseBetweenSpecialAndBasicAttack_SpecialAttack() throws InvalidAttackException {
        int number = 3;
        try(MockedStatic<DiceRoller> diceRollerMockedStatic = Mockito.mockStatic(DiceRoller.class)) {
            diceRollerMockedStatic.when(() -> DiceRoller.rollDice(10)).thenReturn(number);

            PhyrexianMite spyMite = Mockito.spy(new PhyrexianMite("test", 10, 10, 5));

            spyMite.chooseBetweenSpecialAndBasicAttack(mockPlayer);

            Mockito.verify(spyMite).useSpecialAttack(mockPlayer);
        }
    }
}