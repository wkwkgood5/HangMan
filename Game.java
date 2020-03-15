package com.company;

public class Game {
    public static final int MAX_MISSES = 6;
    private String answer;
    private String wrong = "";
    private String right = "";

    public Game(String answer) {
        this.answer = answer;
    }

    private boolean normalizeChar(char letter) {
        if (! Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (wrong.indexOf(letter) != -1 || right.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        boolean isRight = answer.indexOf(letter) != -1;
        if (isRight) {
            right += letter;
        } else {
            wrong += letter;
        }
        return isRight;
    }

    public boolean normalizeString(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("No letter found");
        }
        return normalizeChar(input.charAt(0));
    }

    public int remainingTries() {
        return MAX_MISSES - wrong.length();
    }

    public String currentString() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '_';
            if (right.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWin() {
        return currentString().indexOf('_') == -1;
    }
}
