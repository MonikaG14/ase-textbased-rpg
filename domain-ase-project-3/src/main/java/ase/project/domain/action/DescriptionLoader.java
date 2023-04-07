package ase.project.domain.action;

public interface DescriptionLoader {

    void loadDescription(String filename);
    String getDescription(String key);
}
