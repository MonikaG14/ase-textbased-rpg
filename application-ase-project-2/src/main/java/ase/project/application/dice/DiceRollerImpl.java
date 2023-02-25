package ase.project.application.dice;

import ase.project.domain.dice.Dice;
import ase.project.domain.dice.DiceRoller;

public class DiceRollerImpl implements DiceRoller {
    @Override
    public int rollDice(Dice dice) {
        return dice.roll();
    }
}