import javax.swing.JOptionPane;

public class PlayGame {
    // Class-level variables to keep track of games won and lost
    public static int gamesWon = 0;
    public static int gamesLost = 0;

    public static void main(String[] args) {
        boolean playAgain = true;
        String userReply = "";

        // Main game loop: Allows the user to play the game repeatedly
        do {
            // Create a Hangman game instance
            Hangman aGame = new Hangman();
            processGuesses(aGame);  // Process user's guesses
            determineWinner(aGame); // Determine and display the game outcome
            userReply = JOptionPane.showInputDialog("Do you want to play again: ");
            if (userReply.equals("yes")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        } while (playAgain);

        Summarize(); // Display game summary, including the number of games won and lost
    }

    // Method to process user's guesses during the game
    public static void processGuesses(Hangman aGame) {
        int secretWordLength = aGame.getSecretWord().length();
        int chances = 3 * secretWordLength; // Determine the maximum allowed incorrect guesses
        int usedChances = 0; // Track the number of incorrect guesses made by the user
        char guess;
        int loc = -1;

        // Continue the loop as long as the user has chances left and hasn't guessed the word
        while (usedChances < chances && !(aGame.getSecretWord().equalsIgnoreCase(aGame.getUserGuess()))) {
            usedChances++;
            guess = JOptionPane.showInputDialog("Guess a letter in the secret word: ").toLowerCase().charAt(0);
            loc = -1;

            // Find and replace the guessed letter in the user's current guess
            do {
                loc++;
                loc = aGame.getSecretWord().indexOf(guess, loc);

                if (loc >= 0) {
                    String userOldGuess = aGame.getUserGuess();
                    String userNewGuess = userOldGuess.substring(0, loc) + guess + userOldGuess.substring(loc + 1);
                    aGame.setUserGuess(userNewGuess);
                }
            } while (loc > -1);
            JOptionPane.showMessageDialog(null, aGame.getUserGuess());
        }
    }

    // Method to determine the winner of the game
    public static void determineWinner(Hangman aGame) {
        if (aGame.getUserGuess().equalsIgnoreCase(aGame.getSecretWord())) {
            JOptionPane.showMessageDialog(null, "You won the game:");
            gamesWon++; // Increment the count of games won
        } else {
            JOptionPane.showMessageDialog(null, "You lost the game ");
            gamesLost++; // Increment the count of games lost
        }
    }

    // Method to display a summary of the games played
    public static void Summarize() {
        JOptionPane.showMessageDialog(null, "You lost the game " + gamesLost + " times:");
        JOptionPane.showMessageDialog(null, "You won the game: " + gamesWon + " times:");
    }
}

