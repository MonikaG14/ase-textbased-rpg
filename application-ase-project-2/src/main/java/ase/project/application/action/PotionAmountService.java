package ase.project.application.action;

public class PotionAmountService {
    public void checkAmountOfPotions(Integer amount) {
        if (amount == null) {
            throw new IllegalArgumentException("No potions left!");
        }
    }
}
