package ase.project.application.player;

import ase.project.application.enemies.mobs.PhyrexianMite;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.player.classes.Busker;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.enemy.Enemy;
import ase.project.domain.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BuskerTest {
    private Busker player;
    private Enemy target;

    @Mock
    private Enemy mockTarget;

    @BeforeEach
    public void setUp() {
        player = new Busker("Busker Test",60, 60, 40, 3, 2, 10);
        target = new PhyrexianMite("Test Mite", 25, 30, 10);
    }

    @Test
    void testUseBasicAttack() {
        final int diceRoll = 4;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(6)).thenReturn(diceRoll);
            int expectedDamage = diceRoll + player.getCharisma();

            player.useBasicAttack(target);
            player.useBasicAttack(mockTarget);

            assertEquals(11, target.getCurrentHealth());
            verify(mockTarget).takeDamage(expectedDamage);
        }
    }

    @Test
    void testSpecialAttackListInitialization() {
        Map<String, SpecialAttack> specialAttackMap = player.getSpecialAttackList();

        assertEquals(2, specialAttackMap.size());
        assertTrue(specialAttackMap.containsKey("Earworm"));
        assertTrue(specialAttackMap.containsKey("RickRoll"));
    }

    @Test
    void testUseSpecialAttack_performsCorrectAttack_Earworm() throws InvalidAttackException, InsufficientManaException {
        String attackName = "Earworm";
        int diceRoll = 20;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(20)).thenReturn(diceRoll);

            int expectedHealth = target.getCurrentHealth() - diceRoll;

            player.useSpecialAttack(target, attackName);
            player.useSpecialAttack(mockTarget, attackName);

            assertEquals(expectedHealth, target.getCurrentHealth());
            verify(mockTarget).takeDamage(diceRoll);
        }
    }

    @Test
    void testUseSpecialAttack_performsCorrectAttack_RickRoll() throws InvalidAttackException, InsufficientManaException {
        String attackName = "RickRoll";
        int diceRoll = 20;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(20)).thenReturn(diceRoll);

            int expectedHealth = target.getCurrentHealth() - diceRoll;

            player.useSpecialAttack(target, attackName);
            player.useSpecialAttack(mockTarget, attackName);

            assertEquals(expectedHealth, target.getCurrentHealth());
            verify(mockTarget).takeDamage(diceRoll);
        }
    }
    @Test
    void testUseSpecialAttack_reducesManaByCorrectAmount_Earworm() throws InvalidAttackException, InsufficientManaException {
        String attackName = "Earworm";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(35, player.getMana());
    }

    @Test
    void testUseSpecialAttack_reducesManaByCorrectAmount_RickRoll() throws InvalidAttackException, InsufficientManaException {
        String attackName = "RickRoll";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(30, player.getMana());
    }

    @Test
    void testUseSpecialAttack_throwsInvalidAttackException() {
        String attackName = "Wrong attack name";

        assertThrows(InvalidAttackException.class, () -> player.useSpecialAttack(mockTarget, attackName));
    }
}