package com.company;

import com.company.Cue;
import com.company.Game;

public class Hangman {

    public static void main(String[] args) {
        Game game = new Game("hang");
        Cue cue = new Cue(game);

        while (game.remainingTries() > 0 && !game.isWin()) {
            cue.displayProgress();
            cue.cueForGuess();
        }
        cue.displayOutcome();
    }
}
