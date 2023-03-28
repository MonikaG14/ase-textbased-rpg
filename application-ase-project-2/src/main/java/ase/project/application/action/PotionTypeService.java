package ase.project.application.action;

import ase.project.application.item.potion.PotionFactory;
import ase.project.application.item.potion.PotionType;
import ase.project.domain.item.Potion;

public class PotionTypeService {
    public Potion choosePotionType(PotionType potionType) {
        return PotionFactory.getPotion(potionType);
    }
}
