public class Hangman {

  public static void main(String[] args) {
    
    Game game = new Game("ebay");
    Prompter prompter = new Prompter(game);

    while (game.getRemainingTries() > 0 && !game.isWon()) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }
    prompter.displayOutcome();
  }
}
