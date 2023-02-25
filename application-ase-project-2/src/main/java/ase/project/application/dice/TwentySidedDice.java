package ase.project.application.dice;

import ase.project.domain.dice.Dice;

import java.util.Random;

public class TwentySidedDice implements Dice {

    public final Random random;

    public TwentySidedDice(Random random) {
        this.random = random;
    }

    @Override
    public int roll() {
        return random.nextInt(20) + 1;
    }
}
