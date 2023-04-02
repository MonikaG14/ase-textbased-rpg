package ase.project.application.player;

import ase.project.application.enemies.PhyrexianMite;
import ase.project.application.exception.InvalidAttackException;
import ase.project.application.exception.InvalidManaException;
import ase.project.domain.action.attack.SpecialAttack;
import ase.project.domain.characters.Enemy;
import ase.project.domain.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GladiatorTest {
    private Gladiator player;
    private Gladiator playerWithNoMana;
    private Enemy target;

    @Mock
    Enemy mockTarget;

    @BeforeEach
    public void setUp() {
        player = new Gladiator("Gladiator Test", 60, 60, 40, 3, 2, 10);
        playerWithNoMana = new Gladiator("No Mana Gladiator", 40, 60, 1, 3, 2, 10);
        target = new PhyrexianMite("Test Mite", 25, 30, 10);
    }

    @Test
    void testUseBasicAttack() {
        final int diceRoll = 4;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(6)).thenReturn(diceRoll);
            int expectedDamage = diceRoll + player.getEndurance();

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
        assertTrue(specialAttackMap.containsKey("Gladiator's Gambit"));
        assertTrue(specialAttackMap.containsKey("Spin To Win"));
    }

    @Test
    void testUseSpecialAttack_performsCorrectAttack_GladiatorGambit() throws InvalidAttackException {
        String attackName = "Gladiator's Gambit";
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
    void testUseSpecialAttack_performsCorrectAttack_SpinToWin() throws InvalidAttackException {
        String attackName = "Spin To Win";
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
    void testUseSpecialAttack_reducesManaByCorrectAmount_GladiatorGambit() throws InvalidAttackException {
        String attackName = "Gladiator's Gambit";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(35, player.getMana());
    }

    @Test
    void testUseSpecialAttack_reducesManaByCorrectAmount_SpinToWin() throws InvalidAttackException {
        String attackName = "Spin To Win";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(30, player.getMana());
    }

    @Test
    void testUseSpecialAttack_throwsInvalidManaException() {
        String attackName = "Gladiator's Gambit";

        assertThrows(InvalidManaException.class, () -> {
            playerWithNoMana.useSpecialAttack(mockTarget, attackName);
            throw new InvalidManaException("You do not have enough mana for this attack!");
        });
    }

    @Test
    void testUseSpecialAttack_throwsInvalidAttackException() {
        String attackName = "Wrong attack name";

        assertThrows(InvalidAttackException.class, () -> {
            player.useSpecialAttack(mockTarget, attackName);
        });
    }
}