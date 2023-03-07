package ase.project.application.dice;

import ase.project.domain.dice.DiceRoller;

import java.util.Random;

public class DiceRollerImpl implements DiceRoller {
    private final Random random;

    public DiceRollerImpl(Random random) {
        this.random = random;
    }

    @Override
    public int rollDice(int sides) {
        return random.nextInt(sides) + 1;
    }
}