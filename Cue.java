package com.company;

import java.util.Scanner;

public class Cue {
    private Game game;

    public Cue(Game game) {
        this.game = game;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left: %s%n", game.remainingTries(), game.currentString());
        System.out.print("Enter a letter: ");
    }

    public boolean cueForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isRight = false;
        String input = scanner.nextLine();

        try {
            isRight = game.normalizeString(input);
        } catch(IllegalArgumentException iae) {
            System.out.printf("%s. Please try again.%n", iae.getMessage());
        }
        return isRight;
    }

    public void displayOutcome() {
        if (game.isWin()) {
            System.out.printf("Congratulations, you've won!%n");
        } else {
            System.out.printf("Sorry, you lost!");
        }
    }
}
