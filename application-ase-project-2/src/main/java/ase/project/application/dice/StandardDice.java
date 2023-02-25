package ase.project.application.dice;

import ase.project.domain.dice.Dice;

import java.util.Random;

public class StandardDice implements Dice {
    private final Random random;

    public StandardDice(Random random) {
        this.random = random;
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
