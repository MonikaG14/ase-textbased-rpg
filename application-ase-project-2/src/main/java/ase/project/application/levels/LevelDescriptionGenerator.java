package ase.project.application.levels;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LevelDescriptionGenerator {
    private final List<String> LEVEL_DESCRIPTIONS = Arrays.asList(
            "Deep in the forest lies a mysterious cave...",
            "The ancient ruins hold many secrets...",
            "The great temple has been desecrated...",
            "The castle gates have been breached..."
            //ToDO finish level descriptions
    );

    public String generateDescription() {
        Random random = new Random();
        int index = random.nextInt(LEVEL_DESCRIPTIONS.size());
        return LEVEL_DESCRIPTIONS.get(index);
    }
}
