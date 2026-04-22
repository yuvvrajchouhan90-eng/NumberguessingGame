import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        System.out.println(" Welcome to Number Guessing Game!");

        while (playAgain) {
            int maxRange = 100;
            int attempts = 7;

            // Difficulty selection
            System.out.println("\nSelect Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-500, 5 attempts)");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    maxRange = 50;
                    attempts = 10;
                    break;
                case 2:
                    maxRange = 100;
                    attempts = 7;
                    break;
                case 3:
                    maxRange = 500;
                    attempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium.");
            }

            int number = rand.nextInt(maxRange) + 1;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and " + maxRange);
            System.out.println("You have " + attempts + " attempts to guess it!");

            // Game loop
            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed it in " + i + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (guess > number) {
                    System.out.println("🔺 Too High!");
                } else {
                    System.out.println("🔻 Too Low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost! The correct number was: " + number);
            }

            // Replay option
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("👋 Thanks for playing!");
            }
        }

        sc.close();
    }
}