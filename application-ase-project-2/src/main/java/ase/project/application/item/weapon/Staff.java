package ase.project.application.item.weapon;

import ase.project.domain.item.Weapon;

public class Staff implements Weapon {
    private final String name = "Makeshift Staff";
    private final String description = "You see something purple buried in the dirt." +
            "Wondering what it is, you stretch your hand and sweep some of the dirt away. It looks like an ancient book." +
            "Could this be a powerful artefact from long forgotten ages containing mighty incantations..." +
            "This could save you. You could quickly go back to you boring, but convenient life and never again deal with this horrid creatures." +
            "You dig excitedly and quickly remove the rest of the dirt, pulling something long attached to the worn-out book." +
            "Your heart sinks. You are staring at an old library-book duct-taped to a broom handle." +
            "Is this some kind of joke? Strapping two pieces of garbage together is not solid weapon design..." +
            "Whoever designed this junk did a poor job indeed.";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getItemDescription() {
        return description;
    }

    @Override
    public int getDamage() {
        return 10;
    }
}