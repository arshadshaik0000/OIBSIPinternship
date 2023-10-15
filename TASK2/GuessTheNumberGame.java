import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int numberOfAttempts = 0;
        int maxAttempts = 10; // You can change this to limit the number of attempts.
        int score = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I've generated a number between " + minRange + " and " + maxRange + ". Try to guess it.");

        while (numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the number correctly.");
                hasGuessedCorrectly = true;
                score += maxAttempts - numberOfAttempts + 1; // Calculate score based on attempts left.
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("The generated number is higher than your guess.");
            } else {
                System.out.println("The generated number is lower than your guess.");
            }

            int attemptsLeft = maxAttempts - numberOfAttempts;
            if (attemptsLeft > 0) {
                System.out.println("Attempts left: " + attemptsLeft);
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
                break;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Your score is 0. Better luck next time!");
        } else {
            System.out.println("Your score is: " + score);
        }

        scanner.close();
    }
}
