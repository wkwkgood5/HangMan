public class Game {
  public static final int MAX_MISSES = 7;
  private String answer;
  private String hits;
  private String misses;

  public Game(String answer) {
    this.answer = answer;
    hits = "";
    misses = "";
  }

  private char normalizeGuess(char letter) {    
    if (! Character.isLetter(letter)) {                    //if the input isn't a letter
      throw new IllegalArgumentException("A letter is required");
    }
    letter = Character.toLowerCase(letter);
    if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {      // if the letter has been input
      throw new IllegalArgumentException(letter + " has already been guessed");
    }
    return letter;
  }

  public boolean applyGuess(String letters) {
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));
  }

  public boolean applyGuess(char letter) {
    letter = normalizeGuess(letter);
    boolean isHit = answer.indexOf(letter) != -1;       //if the letter is in the answer, isHit = 1
    if (isHit) {
      hits += letter;
    } else {
      misses += letter;
    }
    return isHit;
  }

  public int getRemainingTries() {
    return MAX_MISSES - misses.length();
  }

  public String getCurrentProgress() {        //show current hits 
    String progress = "";
    for (char letter : answer.toCharArray()) {
      char display = '_';
      if (hits.indexOf(letter) != -1) {
        display = letter;
      }
      progress += display;
    }
    return progress;
  }

  public boolean isWon() {     
    return getCurrentProgress().indexOf('_') == -1;       //if there isn't '_', win the game
  }
}
