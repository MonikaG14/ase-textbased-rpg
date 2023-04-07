package ase.project.adapters;

import ase.project.domain.action.DescriptionLoader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DescriptionLoaderImpl implements DescriptionLoader {

    private final Map<String, String> descriptions;

    public DescriptionLoaderImpl(String filename) {
        this.descriptions = new HashMap<>();
        loadDescription(filename);
    }

    @Override
    public void loadDescription(String filename) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] tokens = line.split(":");
                    if (tokens.length == 2) {
                        String key = tokens[0].trim();
                        String value = tokens[1].trim();
                        descriptions.put(key, value);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load descriptions", e);
        }
    }

    @Override
    public String getDescription(String key) {
        return descriptions.get(key);
    }
}
