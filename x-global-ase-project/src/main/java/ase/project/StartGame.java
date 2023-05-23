package ase.project;

import ase.project.adapters.GameManager;
import ase.project.application.exception.InsufficientManaException;
import ase.project.application.exception.InvalidAttackException;
import ase.project.plugin.PlayerStatsRepositoryImpl;

public class StartGame {
    public static void main( String[] args ) throws InsufficientManaException, InvalidAttackException {

        GameManager gameManager = new GameManager(new PlayerStatsRepositoryImpl());

        gameManager.startGame();
    }
}
