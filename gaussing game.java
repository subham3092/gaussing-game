import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        boolean playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + " - Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempt + " attempts.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("❌ You've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        // Final score
        System.out.println("\n🏁 Game Over! You won " + roundsWon + " round(s).");
        System.out.println("Thanks for playing! 👋");

        scanner.close();
    }
}

