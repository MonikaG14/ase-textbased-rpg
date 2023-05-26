package ase.project.application.levels;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LevelDescriptionGenerator {
    private final List<String> LEVEL_DESCRIPTIONS = Arrays.asList(
            "As you venture further, a sense of anticipation fills your being, leading you to a mysterious cave hidden deep within the forest. \nInside, new creatures await your arrival, but this time, you stand prepared, ready to face whatever challenges lie ahead.\n",
            "As you delve deeper into the forest, you stumble upon ancient ruins shrouded in mystery. \nThese crumbling structures whisper untold tales, beckoning you to uncover their long-held secrets. \nInside, new creatures await your arrival, but this time, you stand prepared, ready to face whatever challenges lie ahead."
    );

    public String generateDescription() {
        Random random = new Random();
        int index = random.nextInt(LEVEL_DESCRIPTIONS.size());
        return LEVEL_DESCRIPTIONS.get(index);
    }
}
