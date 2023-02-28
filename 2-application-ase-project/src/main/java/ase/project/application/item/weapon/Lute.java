package ase.project.application.item.weapon;

import ase.project.domain.item.Weapon;

public class Lute implements Weapon {
    private final String name = "The Lute-nuke";
    private final String description = "There should be something useful around here... Looking around frantically for a while, " +
            "you quickly lose patience and collapse on the ground in despair. Why is it always you?" +
            "Why is life always so cruel towards you? What have you ever done to deserve such a destiny. Always the victim.." +
            "Thinking about all the times people and life didn't treat you right, you stare unconsciously at the tree crowns" +
            "Beautiful shades of blue light are dancing on the velvety green leaves." +
            "This distracts you for a moment from your constant whining of how unfair life is." +
            "Is there water nearby? What are these reflections on the tree leaves?" +
            "Immediately you jump to your feet and spin around." +
            "And there it is! A magnificent lute! Masterfully sculpted, beautifully painted with all shades of sparkling blue." +
            "You take it into your hands still in awe... Maybe life isn't so bad after all.";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
