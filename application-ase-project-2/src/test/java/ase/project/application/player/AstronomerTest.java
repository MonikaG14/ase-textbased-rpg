package ase.project.application.player;

import ase.project.application.enemies.PhyrexianMite;
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
class AstronomerTest {
    private Astronomer player;
    private Astronomer playerWithNoMana;
    private Enemy target;

    @Mock
    Enemy mockTarget;

    @BeforeEach
    public void setUp() {
        player = new Astronomer("AstroTest", 3, 3, 60, 60, 40, 10);
        playerWithNoMana = new Astronomer("No Mana Astro", 3, 3, 40, 60, 1, 10);
        target = new PhyrexianMite("Test Mite", 25, 30, 10, null);
    }

    @Test
    void testUseBasicAttack() {
        final int diceRoll = 4;

        try (MockedStatic<DiceRoller> diceRollerMock = mockStatic(DiceRoller.class)) {
            diceRollerMock.when(() -> DiceRoller.rollDice(6)).thenReturn(diceRoll);
            int expectedDamage = diceRoll + player.getIntelligence();

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
        assertTrue(specialAttackMap.containsKey("Fireball Barrage"));
        assertTrue(specialAttackMap.containsKey("Flame Tsunami"));
    }

    @Test
    void testUseSpecialAttack_performsCorrectAttack_FireballBarrage() {
        String attackName = "Fireball Barrage";
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
    void testUseSpecialAttack_performsCorrectAttack_FlameTsunami() {
        String attackName = "Flame Tsunami";
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
    void testUseSpecialAttack_reducesManaByCorrectAmount_FireballBarrage() {
        String attackName = "Fireball Barrage";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(35, player.getMana());
    }

    @Test
    void testUseSpecialAttack_reducesManaByCorrectAmount_FlameTsunami() {
        String attackName = "Flame Tsunami";

        player.useSpecialAttack(mockTarget, attackName);

        assertEquals(30, player.getMana());
    }

    /*@Test
    void testUseSpecialAttack_throwsInvalidManaException() {
        String attackName = "Fireball Barrage";

        assertThrows(InvalidManaException.class, () -> {
            playerWithNoMana.useSpecialAttack(mockTarget, attackName);
        });
    }
     */
}