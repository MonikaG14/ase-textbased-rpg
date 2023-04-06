package ase.project.application.item.weapon;

import ase.project.domain.item.Weapon;

public class Longsword implements Weapon {
    private final String name = "Cursed Longsword";
    private final String description = "What is going on... Bent over, clutching your knees and out of breath, you see through teary eyes" +
            "a blade. Right in front of your feet the shiny metal is glistening in the sun. Strange runes appear and " +
            "disappear as quickly as they have appeared under your gaze. Their purple shade almost gives off a glowing " +
            "nuance. It can't glow, can it? What is this strange weapon? Overwhelmed with deadly curiosity you pick up the blade." +
            "To your surprise it is light as a feather. You chuckle. You are most assuredly dreaming. Any moment now, you will wake" +
            "up in your soft, warm bed and forget all about this cursed land. You try to throw away the sword, but like a clingy ex," +
            "it just wont let go. Like a lost puppy it clings to you side. No matter how hard you try to get rid of it," +
            "it magically reappears by your side like a creepy stalker." +
            "Any moment now... you will wake up and laugh at this nonsensical dream you just had... ";

    @Override
    public String getItemDescription() {
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
