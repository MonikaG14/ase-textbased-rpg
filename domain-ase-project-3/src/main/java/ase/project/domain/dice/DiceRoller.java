package ase.project.domain.dice;

public class DiceRoller {
    public static int rollDice(int sides) {
        return (int) (Math.random() * sides) + 1;
    }
}