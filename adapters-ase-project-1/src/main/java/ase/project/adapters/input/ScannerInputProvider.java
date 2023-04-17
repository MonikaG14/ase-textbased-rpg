package ase.project.adapters.input;

import ase.project.domain.action.InputProvider;

import java.util.Scanner;

public class ScannerInputProvider implements InputProvider {
    private final Scanner scanner;

    public ScannerInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public boolean readBoolean() {
        return scanner.nextBoolean();
    }
}
