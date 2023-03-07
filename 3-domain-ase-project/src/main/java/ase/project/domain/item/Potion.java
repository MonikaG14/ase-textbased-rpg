package ase.project.domain.item;

public abstract class Potion implements Item {
    public void drink(int attribute) {
        attribute += 10;
    }
}
