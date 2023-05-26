package ase.project.application.enemies;

import ase.project.application.action.specialattack.enemy.Infect;
import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.classes.Busker;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.player.Player;
import ase.project.domain.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PhyrexianMiteTest {
    @Mock
    private Player mockTargetPlayer;
    @Mock
    private PhyrexianMite phyrexianMite;
    @Mock
    private SpecialAttack specialAttack;
    private Busker targetBusker;

    @BeforeEach
    public void setUp() {
        phyrexianMite = new PhyrexianMite("Test Mite", 35, 60,10);
        targetBusker = new Busker("Target Test Busker", 100, 100, 20, 3, 3,10);
        specialAttack = new Infect();
    }

    @Test
    void testUseBasicAttack() {
        final int diceRoll = 2;
        try (MockedStatic<DiceRoller> diceRollerMockedStatic = Mockito.mockStatic(DiceRoller.class)) {
            diceRollerMockedStatic.when(() -> DiceRoller.rollDice(6)).thenReturn(diceRoll);
            int expectedDamage= diceRoll + phyrexianMite.getPower();

            phyrexianMite.useBasicAttack(mockTargetPlayer);

            verify(mockTargetPlayer).takeDamage(expectedDamage);
        }
    }

    @Test
    void testSpecialAttackListInitialization() {
        Map<Integer, SpecialAttack> specialAttackMap = phyrexianMite.getSpecialAttackList();

        assertEquals(1, specialAttackMap.size());
        assertTrue(specialAttackMap.containsKey(1));
    }


    @Test
    void testUseSpecialAttack() throws InvalidAttackException {
        int diceRoll = 10;
        try (MockedStatic<DiceRoller> diceRollerMockedStatic = mockStatic(DiceRoller.class)) {
            diceRollerMockedStatic.when(() -> DiceRoller.rollDice(20)).thenReturn(10);
            int expectedHealth = targetBusker.getCurrentHealth() - diceRoll;

            phyrexianMite.useSpecialAttack(mockTargetPlayer);
            phyrexianMite.useSpecialAttack(targetBusker);

            verify(mockTargetPlayer).takeDamage(diceRoll);
            assertEquals(expectedHealth, targetBusker.getCurrentHealth());
        }
    }

    @Test
    void testChooseBetweenSpecialAndBasicAttack() throws InvalidAttackException {
        int diceRoll = 4;
        try (MockedStatic<DiceRoller> diceRollerMockedStatic = mockStatic(DiceRoller.class)) {
            diceRollerMockedStatic.when(() -> DiceRoller.rollDice(10)).thenReturn(diceRoll);
            PhyrexianMite spyMite = Mockito.spy(new PhyrexianMite("Test Spy Mite", 10, 10, 10));

            spyMite.chooseBetweenSpecialAndBasicAttack(mockTargetPlayer);

            Mockito.verify(spyMite).useBasicAttack(mockTargetPlayer);
        }
    }
}