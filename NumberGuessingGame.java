import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int randomNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int maxAttempts = 5;
        int attemptCount = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerLimit + " and " + upperLimit + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (attemptCount < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attemptCount++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attemptCount + " attempts.");
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }

            System.out.println("Remaining attempts: " + (maxAttempts - attemptCount));
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Game Over! The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}