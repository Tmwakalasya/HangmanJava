import java.util.Random;

public class Hangman {
    private String secretWord; // Stores the secret word that the user needs to guess
    private String userGuess;   // Stores the user's current guesses

    public Hangman() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(1, 6); // Generates a random number between 1 and 5
        userGuess = "";

        // Initialize the secret word based on the random number
        switch (randomNumber) {
            case 1:
                secretWord = "seattle";
                break;
            case 2:
                secretWord = "california";
                break;
            case 3:
                secretWord = "montana";
                break;
            case 4:
                secretWord = "miami";
                break;
            default:
                secretWord = "arizona";
                break;
        }

        // Initialize the user's initial guess with underscores to match the secret word length
        while (userGuess.length() < secretWord.length()) {
            userGuess = userGuess + "_";
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    @Override
    public String toString() {
        return "The secret word is " + secretWord + " and the user guess is " + userGuess;
    }
}
