package ase.project.application.action.potion;

public class PotionAmountService {
    public void checkAmountOfPotions(Integer amount) {
        if (amount == null) {
            throw new NullPointerException("No potions left!");
        }
    }
}
